<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="kr">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" href="/css/bootstrap-datepicker.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script src="/js/bootstrap-datepicker.js"></script>
  <script src="/js/bootstrap-datepicker.ko.min.js"></script>

  <style>
    .pagination {
      margin-top: 16px;
    }
    .pagination > li > a {
      border: 0px;
      border-radius: 0px;
    }
  </style>
  <title>Celeb List</title>
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
          <a class="nav-link" href="#">??????</a>
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
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" value="${searchParam.keyword}">
        <button class="btn btn-outline-primary btn-sm" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<hr>
<table class="table table-striped table-hover" style="width: 98%; margin: auto;">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">??????SEQ</th>
      <th scope="col">??????</th>
      <th scope="col">????????????</th>
      <th scope="col">????????????</th>
      <th scope="col">??????</th>
      <th scope="col">????????????</th>
      <th scope="col">????????????</th>
      <th scope="col">?????????</th>
        <th scope="col">??????????????????</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="celeb" items="${celebList}" varStatus="status">
    <tr data-bs-toggle="modal" data-bs-target="#modalCelebDetails" data-bs-celebDetails="${status.current}">
      <th scope="row">{${status.index}+1}</td>
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
      <td colspan="10" style="text-align: center;">????????? ????????? ????????????:)</td>
    </tr>
    </c:if>
  </tbody>
</table>

<%-- ????????? ??????????????? ?????? --%>
<nav aria-label="Page navigation example">
  <ul class="pagination pagination justify-content-center">
    <%-- '??????' ??????????????? ?????????/???????????? --%>
    <c:choose>
    <c:when test="${pageNavParam.prevActive}">
    <li class="page-item">
    </c:when>
    <c:otherwise>
    <li class="page-item disabled">
    </c:otherwise>
    </c:choose>
      <a class="page-link" href="/celeb/list?page=${pageNavParam.startPage-1}&size=${pageNavParam.contentsPerPage}">??????</a>
    </li>

    <c:forEach var="i" begin="${pageNavParam.startPage}" end="${pageNavParam.endPage}">
    <li class="page-item">
        <a class="page-link" href="/celeb/list?page=${i}&size=${pageNavParam.contentsPerPage}">${i}</a>
    </li>
    </c:forEach>

    <%-- '??????' ??????????????? ?????????/???????????? --%>
    <c:choose>
    <c:when test="${pageNavParam.nextActive}">
    <li class="page-item">
    </c:when>
    <c:otherwise>
    <li class="page-item disabled">
    </c:otherwise>
    </c:choose>
      <a class="page-link" href="/celeb/list?page=${pageNavParam.endPage+1}&size=${pageNavParam.contentsPerPage}">??????</a>
    </li>
  </ul>
</nav>

<hr>

<!-- ???????????? -->
<div class="container-fluid d-grid justify-content-end">
  <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#modalNewCeleb">
  ?????? ??????
  </button>
</div>

<!-- Modal: ???????????? -->
<jsp:include page="./new.jsp" />

<!-- Modal: ???????????? -->
<jsp:include page="./details.jsp" />

</body>
</html>