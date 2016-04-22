function checkOnly(stayChecked)
{
	with(document.myForm)
    {	
    for(i = 0; i < elements.length; i++)
      {
      if(elements[i].checked == true && elements[i].name != stayChecked.name)
        {
        elements[i].checked = false;

        }
      }
    }
	
}

function changeBox(cbox) {
box = eval(cbox);
box.checked = !box.checked;
}

function sub(url,target)
{
    //use timeout coz mousehover fires several times
    clearTimeout(window.ht);
	window.ht = setTimeout(function()
		{
			var div = document.getElementById(target);
			div.innerHTML = '<iframe style="width:285%;height:100%; overflow-x:hidden;" frameborder="0" src="' + url + '" />';
		}
	,20);
	
}