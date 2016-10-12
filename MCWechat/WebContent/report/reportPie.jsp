<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>报表查看</title>
	<script src="../js/require.js"></script>
	<script type="text/javascript">
	
 // Step:3 conifg ECharts's path, link to echarts.js from current page.  
 // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径  
    //var basePath = '<%=basePath%>';
    require.config({  
        paths:{   
            echarts:'../include/echarts/echarts.min',
            jquery:'../include/jquery/jquery-1.10.2.min'
        }  
    });  
      
    // Step:4 require echarts and use it in the callback.  
    // Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径  
    require(  
        [  
            'echarts',
            'jquery'
        ],  
        function(ec) {  
            //--- 折柱 ---  
            var msg = $.ajax({  
		     type: "post",  
		     url: "../report/EchartsReportServlet",  
		     async:false  
		 }).responseText;
		  
		 var dataJson = JSON.parse(msg);
		 category = dataJson.timeList;
		 dataList = dataJson.newList;
		 
		 var chart = document.getElementById('main');  
         var echart = ec.init(chart);         
         echart.showLoading({  
         	text: '正在努力加载中...'  
         });  
		 
		 var option = 
		{
		    title: {
		        text: "部门人数统计",
		        subtext: "人数",
		        textStyle: {
		            fontSize: 12
		        }
		    },
		    tooltip: {
		        trigger: "axis"
		    },
		    legend: {
		        data: ["在岗人数", "编制人数"]
		    },
		    toolbox: {
		        show: true,
		        feature: {
		            mark: {
		                show: true
		            },
		            dataView: {
		                show: true,
		                readOnly: true
		            },
		            magicType: {
		                show: false,
		                type: ["line", "bar"]
		            },
		            restore: {
		                show: true
		            },
		            saveAsImage: {
		                show: true
		            }
		        }
		    },
		    xAxis: [
		        {
		            type: "category",
		            data: category,
		            scale: true,
		            name: "部门",
		            nameLocation: "end",
		            axisLine: {
		                lineStyle: {
		                    color: "rgb(45, 86, 86)"
		                }
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: "value",
		            scale: true,
		            name: "人数"
		            
		        }
		    ],
		    series: [
		        {
		            name: "在岗人数",
		            type: "bar",
		            data: dataList,
		            itemStyle: {
		                normal: {
		                    color: "#FF4500"
		                }
		            }
		            
		        },
		        {
		            name: "编制人数",
		            type: "bar",
		            data: dataList,
		            itemStyle: {
		                normal: {
		                    color: "#90EE90"
		                }
		            }
		        }
		    ]
		};  
                  
                echart.setOption(option);  
                echart.hideLoading();  
        }  
    );  
</script> 
</head>
<body>
	<div id="main" style="width: 600px;height:400px;"></div> 
</body>
</html>