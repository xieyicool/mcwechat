<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>报表查看</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="./include/echarts/echarts3.0.js"></script>
	<script src="./include/jquery/jquery-1.10.2.min.js"></script>
	

  </head>
  
  <body>
    <div id="main1" style="width: 960px;height:700px;"></div>
    <div id="main2" style="width: 960px;height:700px;"></div>
    <script type="text/javascript">	
	var echart1 = echarts.init(document.getElementById('main1'));       
	var echart2 = echarts.init(document.getElementById('main2'));  
    echart1.showLoading({  
         	text: '正在努力加载中...'  
         });
	
	//1.柱状图*********************************************************
	var option = 
		{
		    title: {
		        text: "部门人数统计",
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
		            data: ["人事部", "财务部", "销售部", "市场部", "总经办"],
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
		            name: "人数",
		            min: 0,
		            max: 15
		        }
		    ],
		    series: [
		        {
		            name: "在岗人数",
		            type: "bar",
		            data: [6, 7, 7, 9, 5],
		            itemStyle: {
		                normal: {
		                    color: "#FF4500"
		                }
		            }
		            
		        },
		        {
		            name: "编制人数",
		            type: "bar",
		            data: [7, 8, 5, 7, 6],
		            itemStyle: {
		                normal: {
		                    color: "#90EE90"
		                }
		            }
		        }
		    ]
		};
		//2.折线图*********************************************************
		echart1.showLoading({  
         	text: '正在努力加载中...'  
         });
		var option2 = 
		    {
			    title: {
			        text: "年度人力成本对比表"
			    },
			    tooltip: {
			        trigger: "axis"
			    },
			    legend: {
			        data: ["上年度", "本年度"]
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
			    calculable: true,
			    xAxis: [
			        {
			            type: "category",
			            name: "月份",
			            boundaryGap: false,
			            data: ["1", "2", "3", "4", "5", "6", "7"]
			        }
			    ],
			    yAxis: [
			        {
				      type: "value",
				      name: "万元",
				      min: 0,
				      max: 20
			        }
			    ],
			    
			    series: [
			        {
			            name: "上年度",
			            type: "line",
			            data: [12, 10, 11, 10, 12, 11, 9]
			        },
			        {
			            name: "本年度",
			            type: "line",
			            data: [11, 10, 9, 8.5, 10, 9, 8]
			        }
			    ]
			};	
		echart1.setOption(option);
		echart1.hideLoading();
		echart2.setOption(option2);
		echart2.hideLoading();
	</script>
  </body>
</html>
