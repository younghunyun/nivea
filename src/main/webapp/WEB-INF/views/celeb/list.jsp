<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="kr">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<hr/>
<table class="table table-striped table-hover" style="width: 98%; margin: auto;">
    <thead>
	<tr>
		<th scope="col">#</th>
		<th scope="col">셀럽ID</th>
		<th scope="col">구분코드</th>
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
	<tr>
	  <th scope="row">${status.count}</th>
	  <td>${celeb.celebId}</a></td>
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
	  <td colspan="10">등록된 셀럽이 없습니다:)</td>
	</tr>
	</c:if>
    </tbody>
</table>

<nav aria-label="Page navigation example">
  <ul class="pagination pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>

<hr/>

<div class="container">
<button type="button" class="btn btn-primary btn-sm float-end">신규등록</button>
</div>

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
$(function() {
    var $form = $('#form');
    $form.bind('submit', function() {
        $.ajax({
            url: '/celeb/save',
            type: 'post',
            data: $form.serialize(),
            dataType: 'json',
            success: function(data) {
                if (data.code == 'SUCCESS') {
                    alert('저장됨:)');
                } else {
                    alert(data.message);
                }
            }
        });
        return false;
    });
});
</script>

</body>
</html>