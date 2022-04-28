<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="kr">
<head>
  <meta charset="UTF-8">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script src="/js/bootstrap-datepicker.js"></script>
  <script src="/js/bootstrap-datepicker.ko.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" href="/css/bootstrap-datepicker.css">

  <style>
    .pagination {
      margin-top: 16px;
    }
    .pagination > li > a {
      border: 0px;
      border-radius: 0px;
    }
  </style>
  <title>Board Create/Update</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">셀럽</a>
        </li>
       <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-primary btn-sm" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<hr/>
<table class="table table-striped table-hover" style="width: 98%; margin: auto;">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">셀럽SEQ</th>
      <th scope="col">구분</th>
      <th scope="col">활동이름</th>
      <th scope="col">실제이름</th>
      <th scope="col">성별</th>
      <th scope="col">생년월일</th>
      <th scope="col">데뷔년도</th>
      <th scope="col">소속사</th>
        <th scope="col">업데이트일시</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="celeb" items="${celebList}" varStatus="status">
    <tr data-bs-toggle="modal" data-bs-target="#modalCelebDetails" data-bs-celebDetails="${celeb}">
      <td scope="row"><image src="/image/no_image.png" style="width: 32px; object-fit: cover;"></td>
      <td>${celeb.celebSeq}</a></td>
      <td>${celeb.celebCode}</td>
      <td>${celeb.stageName}</td>
      <td>${celeb.realName}</td>
      <td>${celeb.gender}</td>
      <td>${celeb.birthDate}</td>
      <td>${celeb.debutYear}</td>
      <td>${celeb.company}</td>
      <td>${celeb.updated}</td>
    </tr>
    </c:forEach>
    <c:if test="${fn:length(celebList) == 0}">
    <tr>
      <td colspan="10" style="text-align: center;">등록된 셀럽이 없습니다:)</td>
    </tr>
    </c:if>
  </tbody>
</table>

<%-- 페이지 네비게이션 영역 --%>
<nav aria-label="Page navigation example">
  <ul class="pagination pagination justify-content-center">
    <%-- '이전' 페이지블럭 활성화/비활성화 --%>
    <c:choose>
    <c:when test="${pageNavParam.prevActive}">
    <li class="page-item">
    </c:when>
    <c:otherwise>
    <li class="page-item disabled">
    </c:otherwise>
    </c:choose>
      <a class="page-link" href="./list?page=${pageNavParam.startPage-1}&size=${pageNavParam.contentsPerPage}">이전</a>
    </li>

    <c:forEach var="i" begin="${pageNavParam.startPage}" end="${pageNavParam.endPage}">
    <li class="page-item">
        <a class="page-link" href="./list?page=${i}&size=${pageNavParam.contentsPerPage}">${i}</a>
    </li>
    </c:forEach>

    <%-- '다음' 페이지블럭 활성화/비활성화 --%>
    <c:choose>
    <c:when test="${pageNavParam.nextActive}">
    <li class="page-item">
    </c:when>
    <c:otherwise>
    <li class="page-item disabled">
    </c:otherwise>
    </c:choose>
      <a class="page-link" href="./list?page=${pageNavParam.endPage+1}&size=${pageNavParam.contentsPerPage}">다음</a>
    </li>
  </ul>
</nav>

<hr/>

<!-- 신규등록 -->
<div class="container-fluid d-grid justify-content-end">
  <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#modalNewCeleb">
  셀럽 등록
  </button>
</div>

<!-- Modal: 신규등록 -->
<jsp:include page="./new.jsp" />

<!-- Modal: 상세정보 -->
<jsp:include page="./details.jsp" />


</body>
</html>