<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


            <div id="left-menu">
              <div class="sub-left-menu scroll">
                <ul class="nav nav-list">
                    <li><div class="left-bg"></div></li>
                    <li class="time">
                      <h1 class="animated fadeInLeft">21:00</h1>
                      <p class="animated fadeInRight">Sat,October 1st 2029</p>
                    </li>
                    <li class="active ripple" onclick= "window.location.href='/main';"><a href=""><span class="fa-home fa"></span>메인</a></li>

                    <li class="ripple">
                      <a class="tree-toggle nav-header">
                        <span class="fa-area-chart fa"></span> 검침 조회
                        <span class="fa-angle-right fa right-arrow text-right"></span>
                      </a>
                      <ul class="nav nav-list tree">
                        <li onclick= "window.location.href='/used/usedCurrent';"><a href="">현재 검침값</a></li>
                      </ul>
                    </li>
                  </ul>
                </div>
            </div>

<script>
var datetime = null,
date = null;

var update = function () {
date = moment(new Date())
datetime.html(date.format('HH:mm'));
datetime2.html(date.format('dddd, MMMM Do YYYY'));
};

$(document).ready(function(){
datetime = $('.time h1');
datetime2 = $('.time p');
update();
setInterval(update, 1000);
});

</script>