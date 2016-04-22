library(quantmod)
library(lubridate)
library(e1071)
library(rpart)
library(rpart.plot)
library(ROCR)

options(warn = -1)
a <- c('AAPL', 'FB', 'GE', 'GOOG', 'GM', 'IBM', 'MSFT')
for (i in 1:length(a))
{
  SYM <- a[i]
  print('-------------------------------------------------------------------------')
  print(paste('Predicting the output for', SYM, sep = ' '))
  trainPerc <- 0.75
  date <- as.Date(Sys.Date() - 1)
  endDate <- date#as.Date("2016-01-01")
  d <- as.POSIXlt(endDate)
  d$year <- d$year - 2
  startDate <- as.Date(d)
  STOCK <- getSymbols(
    SYM,
    env = NULL,
    src = "yahoo",
    from = startDate,
    to = endDate
  )
  RSI3 <- RSI(Op(STOCK), n = 3)
  #Calculate a 3-period relative strength index (RSI) off the open price
  EMA5 <- EMA(Op(STOCK), n = 5)
  #Calculate a 5-period exponential moving average (EMA)
  EMAcross <- Op(STOCK) - EMA5
  #Let us explore the difference between the open price and our 5-period EMA
  MACD <- MACD(Op(STOCK),
               fast = 12,
               slow = 26,
               signal = 9)
  #Calculate a MACD with standard parameters
  MACDsignal <- MACD[, 2]
  #Grab just the signal line to use as our indicator.
  SMI <- SMI(
    Op(STOCK),
    n = 13,
    slow = 25,
    fast = 2,
    signal = 9
  )
  #Stochastic Oscillator with standard parameters
  SMI <- SMI[, 1]
  #Grab just the oscillator to use as our indicator
  WPR <- WPR(Cl(STOCK), n = 14)
  WPR <- WPR[, 1]
  ADX <- ADX(STOCK, n = 14)
  ADX <- ADX[, 1]
  CCI <- CCI(Cl(STOCK), n = 14)
  CCI <- CCI[, 1]
  CMO <- CMO(Cl(STOCK), n = 14)
  CMO <- CMO[, 1]
  ROC <- ROC(Cl(STOCK), n = 2)
  ROC <- ROC[, 1]
  PriceChange <- Cl(STOCK) - Op(STOCK)
  #Calculate the difference between the close price and open price
  Class <- ifelse(PriceChange > 0, "UP", "DOWN")
  #Create a binary classification variable, the variable we are trying to predict.
  DataSet <-
    data.frame(Class, RSI3, EMAcross, MACDsignal, SMI, WPR, ADX, CCI, CMO, ROC)
  #Create our data set
  colnames(DataSet) <-
    c(
      "Class",
      "RSI3",
      "EMAcross",
      "MACDsignal",
      "Stochastic",
      "WPR",
      "ADX",
      "CCI",
      "CMO",
      "ROC"
    )
  #Name the columns
  #DataSet <- DataSet[-c(1:33),]#33
  #Get rid of the data where the indicators are being calculated
  TrainingSet <- DataSet[1:floor(nrow(DataSet) * trainPerc), ]
  #Use 2/3 of the data to build the tree
  TestSet <-
    DataSet[(floor(nrow(DataSet) * trainPerc) + 1):nrow(DataSet), ]
  #And leave out 1/3 data to test our strategy
  DecisionTree <-
    rpart(
      Class ~ RSI3 + EMAcross + WPR + ADX + CMO + CCI + ROC,
      #+ MACDsignal + Stochastic,
      data = TrainingSet,
      na.action = na.omit,
      cp = .001
    )
  #Specifying the indicators to we want to use to predict the class and controlling the growth of the tree by setting the minimum amount of information gained (cp) needed to justify a split.
  prp(DecisionTree, type = 2, extra = 8)
  #Nice plotting tool with a couple parameters to make it look good. If you want to play around with the visualization yourself, here is a great resource.
  fit <- printcp(DecisionTree)
  #shows the minimal cp for each trees of each size.
  mincp <- fit[which.min(fit[, 'xerror']), 'CP']
  #Get the lowest cross-validated error (xerror)
  plotcp(DecisionTree, upper = "splits")
  #plots the average geometric mean for trees of each size.
  PrunedDecisionTree <- prune(DecisionTree, cp = mincp)
  #We are selecting the complexity parameter (cp) that has the lowest cross-validated error (xerror)
  t <- prp(PrunedDecisionTree, type = 2, extra = 8)
  confmat <-
    table(
      predict(PrunedDecisionTree, TestSet, type = "class"),
      TestSet[, 1],
      dnn = list('predicted', 'actual')
    )
  print(confmat)
  tryCatch({
    acc <-
      (confmat[1, "DOWN"] + confmat[2, "UP"]) * 100 / (confmat[2, "DOWN"] + confmat[1, "UP"] + confmat[1, "DOWN"] + confmat[2, "UP"])
    #if (acc > 60) {
    xy <-
      paste('Decision Tree : Considering the output for', SYM, sep = ' ')
    yz <-
      paste('Accuracy',
            acc,
            sep = ' ')
    out <- paste(xy, yz, sep = '\n')
    print(out)
    write(out,
          file = "out",
          append = TRUE,
          sep = "\n\n")
    #}
  }, error = function(e) {
    
  })
  predout <- data.frame(predict(PrunedDecisionTree, TestSet))
  predval <- predout['UP'] - predout['DOWN']
  predclass <- ifelse(predout['UP'] >= predout['DOWN'], 1, 0)
  predds <- data.frame(predclass, TestSet$Class)
  colnames(predds) <- c("pred", "truth")
  predds[, 2] <- ifelse(predds[, 2] == 'UP', 1, 0)
  #print(predds)
  pred <- prediction(predds$pred, predds$truth)
  perf = performance(pred, measure = "tpr", x.measure = "fpr")
  plot(perf, col = 1:10)
  auc.perf = performance(pred, measure = 'auc')
  rmse.perf = performance(pred, measure = 'rmse')
  print(paste('RMSE =', rmse.perf@y.values), sep = ' ')
  print(paste('AUC =', auc.perf@y.values), sep = ' ')
  abline(a = 0, b = 1, col = "red")
  print('-------------------------------------------------------------------------')
}
print('-------------------------------------------------------------------------')