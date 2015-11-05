;
var widgetUtils = {

    //confirm dialog
    showConfirm:function(txtDesc,func_ok,func_cancel)
    {
        var r=confirm(txtDesc);
        if (r==true)
          {
            func_ok();
          }
        else
          {
            func_cancel();
          }
    }

}