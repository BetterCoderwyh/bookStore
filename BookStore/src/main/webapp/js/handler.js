var cks=document.getElementsByName("cks");
var one=document.getElementById("one");
var two=document.getElementById("two");
function selectAll(obj)
{
	if(obj.checked)
		{
			for(var i in cks)
				{
					cks[i].checked=true;
				}
		}
	else
		{
			for(var i in cks)
				{
					cks[i].checked=false;
				}
		}
}
function delMore()
{
	
	var count=0;
	one.style.display="none";
	two.style.display="none"
	for(var i in cks)
		{
			if(cks[i].checked)
				{
					count++;
				}
		}
	if(count==0)
		{
		one.style.display="block";
		}
	else{
		two.style.display="block";
	}
}
function delMoreReal() {
		var bid="";
	for(var i=0;i<cks.length;i++)
		{
			if(cks[i].checked){
			bid+=cks[i].value+":";}
		}
		window.location.href="/BookShow/book/Handler/delMore?bid="+bid;
	
}

function selectNewImg(){
	var file=document.getElementById("myImg");
	file.click();
	
}
/**改变图书显示条数**/
function changeSize(obj){
//	alert("===")
	//获取当前显示的条数
	var size = obj.value;
	window.location.href="/BookStore/myorder/list?pageSize="+size;
//	window.location.href="http://www.baidu.com"
}

/**跳转页**/
function goPage(){
	//1.获取跳转框中的数据
	var v = document.getElementById("toPages").value;
	
	//2.进行参数有效性判断..判断输入的数据是一个整数
	var regex = /^[0-9]+$/;
	
	if(!regex.test(v)){
		alert("输入的数据不合法!");
		return;
	}
	//获取条数
	var size = document.getElementById("size").value;
	window.location="/BookStore/myorder/list?pageSize="+size+"&pageNow="+v;
	
}

