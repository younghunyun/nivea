<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
  <title>TEST</title>
</head>
<body>

<!-- 테스트 버튼 -->
<div class="container-fluid">
  <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#modalTest">
  셀럽 등록
  </button>
</div>

<!-- Modal: 셀럽 상세정보 -->
<div class="modal fade" id="modalTest" tabindex="-1" aria-labelledby="modalLabelTest" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <h5 class="modal-title" id="modalLabelTest">테스트 모달</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>

      <div class="modal-body">

        <hr>
        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="imageFile" class="form-label">이미지 파일 업로드</label>
            <input class="form-control" type="file" id="imageFile" name="imageFile" onchange="previewImage()" accept="image/*">
            <div class="my-1 float-end">
              <button class="btn btn-outline-secondary btn-sm" onclick="clearImage()">파일 삭제</button>
              <button class="btn btn-outline-secondary btn-sm" id="uploadImageFile" onclick="uploadImage()" disabled>파일 업로드</button>
            </div>
          </div>
        </div>


        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="imagePreview" class="form-label">업로드 이미지 미리보기</label>
            <img id="imagePreview" src="" class="img-fluid" />
          </div>
        </div>

      </div>  <!-- div class="modal-body" -->

      <div class="modal-footer">
        <button class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>

    </div>
  </div>
</div>

<script type="text/javascript">
function previewImage() {
  document.getElementById('imagePreview').src = URL.createObjectURL(event.target.files[0]);
  document.getElementById('uploadImageFile').removeAttribute("disabled");
  alert('previewImage');
};

function clearImage() {
  document.getElementById('imagePreview').src = "";
  document.getElementById('imageFile').value = "";
  document.getElementById('uploadImageFile').setAttribute("disabled", "true");
  alert('clearImage');
};
</script>

</body>
</html>