<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
.responsive-table th{
	text-align: center;
	font-size:11px;
}
.responsive-table td{
	text-align: center;
	font-size:10px;
}
.responsive-table .no{
	width: 6%;
	padding-bottom:15px;
}
.responsive-table .day{
	width: 17%;
	padding-bottom:15px;
}
.responsive-table .time{
	width: 9%;
	padding-bottom:15px;
}
.responsive-table .lp_act{
	width:17%;
}
.responsive-table .act{
	width: 17%;
}
.responsive-table .lp_ract{
	width: 17%;
}
.responsive-table .ract{
	width: 17%;
}
.btn_green,.btn_blue,.btn_gray,.btn_red {display:inline-block;padding:2px 16px;border-radius:4px;cursor:pointer;}
.btn_green span,.btn_blue span,.btn_gray span, .btn_red span{display:inline-block;color:#ffffff;font-family:'Nanum Gothic Bold';}

.btn_green {background:#86c308;border:1px solid #7db609;}
.btn_green:hover {text-decoration:none;background:#80ba08;}
</style>

            <div id="content">
                <div class="panel">
                  <div class="panel-body">
                      <div class="col-md-6 col-sm-12">
                        <h3 class="animated fadeInLeft">현재 검침값 조회</h3>

                    </div>
                  </div>                    
                </div>

                <div class="col-md-12" style="padding:20px;">
                    <div class="col-md-12 padding-0">
                    
                        <div class="col-md-12 padding-0">
                            <div class="col-md-12 padding-0">
                            
                            <div class="col-md-12">
                                <div class="panel box-v4">
                                    <div class="panel-heading bg-white border-none">
                                      <h4><span class="icon-bolt"></span>현재 검침값</h4>                                     
                                    </div>
                                </div> 
                            </div>
                            
    <div class="col-md-12">
                <div class="col-md-12 panel">
                  <div class="col-md-12 panel-heading">
                    <h4 style="font-size: 12px;">[설명서]<br/>
                    1. 동호수 입력예시 ex) 501동 101호 => 501 , 101 각각 입력후 검색<br/>
                    2. 검색 시간 기준으로 -10시간 까지 검색되도록 하였습니다.
                    </h4>
                  </div>
                  <div class="col-md-12 panel-body">
                    <div class="col-md-12">
                    
                   
 <form action="/used/usedCurrent" name="usedCurrentSearch" method="post" >
                     <div class="col-md-3">
                      <div class="form-group form-animate-text" style="margin-top:40px !important;">
                     
                        <input type="text"  id="addr1" name="addr1" class="form-text mask-date"> 
                        <span class="bar"></span>
                        <label>아파트 동</label>
                      </div>                      
                    </div>
                    
                    
                    <div class="col-md-3">
                      <div class="form-group form-animate-text" style="margin-top:40px !important;">
                        <input type="text" id="addr2" name="addr2" class="form-text mask-phone_with_ddd" >
                        <span class="bar"></span>
                        <label>아파트 호수</label>
                      </div>
                    </div>
                    
                    
                    <div class="col-md-3">
<!--                     <button type="submit" class="btn ripple-infinite btn-outline btn-3d btn-default" style="margin-top:40px !important;">
                     <div><span>조회</span></div>
                     </button> -->
					<a href="javascript:clickSearchBtn();" class="btn_green ml10" style="margin-top:50px !important;"
					onKeyDown="onKeyDown();"><span>검색</span></a>                     
                    </div>      
                    <div class="clear"></div>

                    <div class="col-md-12">
                       <div id="checkTime" style="display: none;">
					<b> 조회시간 : <span id="searchTime"></span></b>
					</div>
                  <div class="responsive-table">                      
                    <table class="table table-striped table-bordered" width="100%" cellspacing="0">
                    <thead>
                      <tr>
                        <th class="no" >번호</th>
                        <th class="day">날짜</th>
                        <th class="time">시간</th>
                        <th class="lp_act">유효 사용량 <br/>(kWh)</th>
                        <th class="act">유효 누적사용량 <br/>(kWh)</th>
                        <th class="lp_ract">무효 사용량 <br/>(kWh)</th>
                        <th class="ract">무효 누적사용량 <br/>(kWh)</th>
                      </tr>
                    </thead>
                    <tbody>                    
									<c:choose>
									<c:when test="${empty usedShow }">
									데이터를 검색해주세요.
									<br/><br/>
									</c:when>
									<c:otherwise>
										<c:set var="doneLoop" value="false" />
										<c:forEach begin="0" end="${usedShow.size()-1}" var="i">
												<c:if test="${not doneLoop }">
												<tr>
								                        <td>	${usedShow[i].rownum}</td>
								                        <td>${usedShow[i].lp_cptr_onlydate}</td>
								                        <td>${usedShow[i].lp_cptr_onlytime}</td>
								                        <td>${usedShow[i].lp_act_pwrer}</td>
								                        <td>${usedShow[i].act_pwrer}</td>
								                        <td>${usedShow[i].lp_ract_pwrer}</td>
								                        <td>${usedShow[i].ract_pwrer}</td>
								                </tr>
									<c:if test="${i+1 == page.totalRecord} }">
										<c:set var="doneLoop" value="true" />
									</c:if>
								</c:if>
						</c:forEach>
						
					</c:otherwise>
				</c:choose>	
                    </tbody>
                  </table>
                  </div>
                  <div class="col-md-6" style="padding-top:20px;">
                    <span>${page.nowPage+1 } - ${page.totalPage} of ${page.totalRecord } </span>
                  </div>
                  <div class="col-md-6">
                  <c:if test="${page.totalRecord !=0}">
                        <ul class="pagination pull-right">
                          <li>
                          <c:if test="${page.nowBlock > 0 }">
                            <a href="#" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>                              
                            </a>
                          </c:if>  
                          </li>
               <c:set var="doneLoop2" value="false" />
				<c:forEach begin="0" end="${page.pagePerBlock }" var="i">
					<c:if test="${not doneLoop2 }">
					<a href="javascript:pagemove(${i })"> ${(page.nowBlock*page.pagePerBlock)+i+1}</a>
					<c:if test="${(page.pagePerBlock*page.nowBlock+i+1) == page.totalPage }">
					<c:set var="doneLoop2" value="true" />  
					</c:if>
					</c:if>
				</c:forEach>
                          <!-- <li class="active"><a href="#">1</a></li> -->
<!--                           <li><a href="#">2</a></li> -->
                          <li>
                          <c:if test="${page.totalBlock > page.nowBlock+1 }">
                            <a href="#" aria-label="Next">
                              <span aria-hidden="true">&raquo;</span>
                            </a>
                            </c:if>
                          </li>
                        </ul>
                        </c:if>
                  </div>
                    </div>  
</form> 


                  </div>
                  
                </div>
              


                                
                            </div>
                        </div>
                        </div>
				   </div>
      		  </div>
</div>
</div>

	<form name="read" method="post">
		<input type="hidden" name="seq"/>
		<input type="hidden" name="addr1"/>
		<input type="hidden" name="addr2"/>
	</form>
	<form name="pagemove" method="POST" action="/used/usedCurrent" >
			<input type="hidden" name="nowBlock" value="${page.nowBlock}" /> 
			<input type="hidden" name="nowPage" value="${page.nowBlock*page.pagePerBlock}" /> 
			<input type="hidden"name="addr1" value="${addr1 }" /> 
			<input type="hidden"name="addr2" value="${addr2 }" />
		</form>
	<form name="list" method="GET">
		<input type="hidden" name="reload" value="true">
	</form>


    <!-- custom -->
     <script src="/js/main.js"></script>     
     <script>
     function onKeyDown()
     {
          if(event.keyCode == 13)
          {
               //TODO : 실행시킬 코드
          }
     }
     
 	// 검색버튼 클릭.
 	function clickSearchBtn(){
 		var dataAddr1= document.getElementById("addr1").value;
 		var dataAddr2 = document.getElementById("addr2").value;
 		
 		
 		if(dataAddr1 == "" || dataAddr1 == null || dataAddr2 == "" || dataAddr2 == ""){
 			alert('동호수를 입력해주세요.')
 		}else{ 		
 			searchGo();
	 		document.usedCurrentSearch.submit();		 		
 		}
 		
 	}
 	
 	
	function searchGo(){
			var msg={
 					label_date_format_yymmdd_hhmmss:'yyyy년 MM월 dd일 a/p hh시 mm분 ss초', 					
 			};
 			Date.prototype.format = function(f) {
 			    if (!this.valueOf()) return " ";
 			 
 			    var weekName = ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'];
 			    var d = this;
 			     
 			    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
 			        switch ($1) {
 			            case "yyyy": return d.getFullYear();
 			            case "yy": return (d.getFullYear() % 1000).zf(2);
 			            case "MM": return (d.getMonth() + 1).zf(2);
 			            case "dd": return d.getDate().zf(2);
 			            case "E": return weekName[d.getDay()];
 			            case "HH": return d.getHours().zf(2);
 			            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
 			            case "mm": return d.getMinutes().zf(2);
 			            case "ss": return d.getSeconds().zf(2);
 			            case "a/p": return d.getHours() < 12 ? '오전' : '오후';
 			            default: return $1;
 			        }
 			    });
 			};
 			
 			String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
 			String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
 			Number.prototype.zf = function(len){return this.toString().zf(len);}; 			

 			//검색시간 표시.
 			viewSearchTime();
 			
 			function viewSearchTime(){
 				document.getElementById("checkTime").style.display ="block";
 				
 				var nowTime = new Date().format(msg.label_date_format_yymmdd_hhmmss);
 				$("#searchTime").html(nowTime);
 			}
	}
	
	

	function list() {
		document.list.action = "/used/usedCurrent";
		document.list.submit();
	}
	
	
	function pagemove(i) {
		var nowPage = document.pagemove.nowPage.value;
		document.pagemove.nowPage.value = Number(nowPage) + Number(i);

		document.pagemove.submit();
	}

	

	
     </script>