$(function() {
        $("#nav").load("${path}/book/nav");
    });
    $(function() {
        $("#book1").load("${path}/jingxuan/list");
    });
    $(function() {
        $("#book2").load("${path}/tuijian/list");
    });
    $(function() {
        $("#book3").load("${path}/tejia/list");
    });
    function booklist(styleId,bookName,pageSize,pageNow){
         bookName=document.getElementById("bookName").value;
        var book1=document.getElementById("book1");
        var book2=document.getElementById("book2");
        var book3=document.getElementById("book3");
        var list=document.getElementById("list");
        book1.style.display="none";
        book2.style.display="none";
        book3.style.display="none";
        $("#list").load("${path}/book/list",{"styleId":styleId,"bookName":bookName,"pageSize":pageSize,"pageNow":pageNow});
        list.style.display="block"; 
    }
    
    function booksearch(){
    	var bookName=document.getElementById("bookName").value;
    	var size=document.getElementById("size");
    	var pageSize=2;
    	var styleId="";
    	if(size!=null){
    		var options=size.getElementsByTagName("option");
    		for(var i=0;i<options.length;i++)
            {
              if(options[i].selected)
                  pageSize=options[i].value;
            }
    	}
    	var style=document.getElementById("bsid");
    	if(style!=null)
    		{
    		styleId=style.value;
    		}
    	booklist(styleId,bookName,pageSize,1);
    }
    function goPage(styleId,bookName,pageSize)
    {
           //1.获取跳转框中的数据
        var v = document.getElementById("toPages").value;
        
        //2.进行参数有效性判断..判断输入的数据是一个整数
        var regex = /^[0-9]+$/;
        
        if(!regex.test(v)){
            alert("输入的数据不合法!");
            return;
        }
        booklist(styleId,bookName,pageSize,v);
    }
    function changeSize(styleId,bookName,obj,pageNow) {
        alert(obj.value);
        booklist(styleId,bookName,obj.value,pageNow);
    }