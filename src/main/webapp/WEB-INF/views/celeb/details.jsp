<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal: 셀럽 상세정보 -->
<div class="modal fade" id="modalCelebDetails" tabindex="-1" aria-labelledby="modalLabelCelebDetails" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <h5 class="modal-title" id="modalLabelCelebDetails">셀럽 정보</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>

      <div class="modal-body">

        <form id="formCelebDetails">
        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="celebSeq" class="form-label">셀럽SEQ</label>
            <input type="text" class="form-control" id="celebSeq" readonly>
          </div>
          <div class="col mx-2 mb-3">
            <label for="celebCode" class="form-label">셀럽구분</label>
            <select class="form-select" id="celebCode">
              <option value="ACT">배우</option>
              <option value="SIN">가수</option>
              <option value="UND">미확인</option>
            </select>
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="stageName" class="form-label">활동이름*</label>
            <input type="text" class="form-control" id="stageName">
          </div>
          <div class="col mx-2 mb-3">
            <label for="stageNameEn" class="form-label">활동이름(영문)</label>
            <input type="text" class="form-control" id="stageNameEn">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="realName" class="form-label">실제이름</label>
            <input type="text" class="form-control" id="realName">
          </div>
          <div class="col mx-2 mb-3">
            <label for="realNameEn" class="form-label">실제이름(영문)</label>
            <input type="text" class="form-control" id="realNameEn">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="gender" class="form-label">성별</label>
            <div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderF">
                <label class="form-check-label" for="genderF">여성</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderM">
                <label class="form-check-label" for="genderM">남성</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderO" checked>
                <label class="form-check-label" for="genderO">기타</label>
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="birthDate" class="form-label">생년월일</label>
            <div class="input-group" data-provide="birthDate">
              <i class="bi bi-calendar-date mx-2" style="font-size: 1.6rem;"></i>
              <input type="text" class="form-control datepicker" id="birthDate" value="" readonly>
            </div>
          </div>
          <div class="col mx-2 mb-3">
            <label for="debutYear" class="form-label">데뷔년도</label>
            <input type="number" class="form-control" id="debutYear" min='1900' max='2040' step='1'>
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="country" class="form-label">국가</label>
            <input type="text" class="form-control" id="country">
          </div>
          <div class="col mx-2 mb-3">
            <label for="countryEn" class="form-label">국가(영문)</label>
            <input type="text" class="form-control" id="countryEn">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="state" class="form-label">시/도</label>
            <input type="text" class="form-control" id="state">
          </div>
          <div class="col mx-2 mb-3">
            <label for="city" class="form-label">시/군/구</label>
            <input type="text" class="form-control" id="city">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="height" class="form-label">키</label>
            <input type="number" class="form-control" id="height" min='100' max='300' step='0.01'>
          </div>
          <div class="col mx-2 mb-3">
            <label for="weight" class="form-label">무게</label>
            <input type="number" class="form-control" id="weight" min='50' max='250' step='0.01'>
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="company" class="form-label">소속사</label>
            <input type="text" class="form-control" id="company">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="updated" class="form-label">업데이트 일시</label>
            <input type="text" class="form-control" id="updated" readonly>
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3 float-end">
            <div class="my-1 float-end">
              <button class="btn btn-primary" id="updateCeleb">변경저장</button>
            </div>
          </div>
        </div>
        </form>  <!-- form id="formCelebDetails" -->

        <hr>
        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="imageFiles" class="form-label">이미지 파일 업로드</label>
            <input class="form-control" type="file" id="imageFiles" name="imageFiles" onchange="previewImages()" accept="image/*" multiple>
            <div class="my-1 float-end">
              <button class="btn btn-outline-secondary btn-sm" onclick="clearPreviews()">파일 삭제</button>
              <button class="btn btn-outline-secondary btn-sm" id="uploadFiles" onclick="uploadImages()" disabled>파일 업로드</button>
            </div>
          </div>
        </div>

        <div class="row" id="previewImages">
          <div class="col mx-2 mb-3">
            <label class="form-label">이미지 미리보기</label>
          </div>
        </div>

        <hr>
        <div class="row">
          <div class="col mx-2 mb-3">
            <div class="accordion" id="accordionPanelsStayOpenExample">
              <div class="accordion-item">
                <h2 class="accordion-header" id="panelsStayOpen-headingOne">
                  <button class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="false" aria-controls="panelsStayOpen-collapseOne">
                    셀럽 이미지
                  </button>
                </h2>
                <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse" aria-labelledby="panelsStayOpen-headingOne">
                  <div class="accordion-body" id="celebImages">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>  <!-- div class="modal-body" -->

      <div class="modal-footer">
        <button class="btn btn-primary" id="celebExt" data-bs-target="#modalCelebExt" data-bs-toggle="modal">추가정보보기</button>
        <button class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>

    </div>
  </div>
</div>

<script type="text/javascript">
$('#formCelebDetails #birthDate').datepicker(datePickerDefaults);

function previewImages() {
  var inputFile = $("input[name='imageFiles']"); // Getting the properties of file from file field
  var files = inputFile[0].files;

  if(files.length > 0) {
    for (var i=0; i<files.length; i++) {
      $("#previewImages").after(
          '<div class="row dynamicPreview" id="dynamicPreview'+i+'">'
          + '<div class="col mx-2 mb-3">'
          + '<label for="dynamicPreview'+i+'" class="form-label">'+files[i].name+'</label>'
          + '<img id="dynamicPreview'+i+'" src="'+URL.createObjectURL(files[i])+'" class="img-fluid" />'
          + '</div>'
          + '</div>'
      );
    }
    document.getElementById('uploadFiles').removeAttribute("disabled");
  } else {
    //
  }
};

function clearPreviews() {
  console.log('fn:clearPreviews()');
  document.getElementById('imageFiles').value = "";

  // class 항목에 dynamicPreview 값이 포함된 element 추출
  var previews = document.querySelectorAll('.dynamicPreview');
  if(previews.length > 0) {
    for (var i=0; i<previews.length; i++) {
      console.log('fn:clearPreviews() | 이전 화면의 프리뷰 삭제 | div id:'+previews[i].id);
      document.getElementById(previews[i].id).remove();
    }
  }

  document.getElementById('uploadFiles').setAttribute("disabled", "true");
};

function uploadImages() {
  var refId = 'CELEB_'+document.getElementById('celebSeq').value;
  console.log('fn:uploadImages() | redId: '+refId);

  var formData = new FormData();                // Creating object of FormData class
  var inputFiles = $("input[name='imageFiles']"); // Getting the properties of file from file field
  var files = inputFiles[0].files;
  if(files.length > 0) {
    for (var i=0; i<files.length; i++) {
      formData.append("uploadFiles", files[i]);
    };

    $.ajax({
      url: '/image/save/'+refId,
      type: 'post',
      data: formData,
      dataType: 'json',
      processData: false,
      contentType: false,
      cache: false,
      success: function(response) {
         if (response.code == 'SUCCESS') {
              alert('fn:uploadImages() | 업로드 완료:)');
              clearPreviews();
              loadImages(refId);
          } else {
              alert('fn:uploadImages() | 업로드 실패 | 메시지: '+response.message);
          }
      },
      error: function(response) {
        alert('fn:uploadImages() | 업로드 오류');
      }
    });
  }
};
</script>

<script type="text/javascript">
// 상세정보 Modal 화면이 보이는 시점에서의 초기 설정
var mcd = document.getElementById('modalCelebDetails');
mcd.addEventListener('show.bs.modal', function (event) {
  // source element that triggered the modal
  var sourceElement = event.relatedTarget;

  // Extract info from data-bs-* attributes
  var celebDetails = sourceElement.getAttribute('data-bs-celebDetails');

  // Set celebDetails to the trigger buttons
  var buttonCelebExt = mcd.querySelector('.modal-footer button#celebExt');
  buttonCelebExt.setAttribute("data-bs-celebDetails", celebDetails);

  // Set modal element value
  mcd.querySelector('.modal-body input#celebSeq').value =    extractCelebInfo(celebDetails, 'celebSeq');
  //mcd.querySelector('.modal-body input#celebCode').value = extractCelebInfo(celebDetails, 'celebCode');
  mcd.querySelector('.modal-body input#stageName').value =   extractCelebInfo(celebDetails, 'stageName');
  mcd.querySelector('.modal-body input#stageNameEn').value = extractCelebInfo(celebDetails, 'stageNameEn');
  mcd.querySelector('.modal-body input#realName').value =    extractCelebInfo(celebDetails, 'realName');
  mcd.querySelector('.modal-body input#realNameEn').value =  extractCelebInfo(celebDetails, 'realNameEn');
  //mcd.querySelector('.modal-body input#gender').value =    extractCelebInfo(celebDetails, 'gender');
  mcd.querySelector('.modal-body input#birthDate').value =   extractCelebInfo(celebDetails, 'birthDate');
  mcd.querySelector('.modal-body input#debutYear').value =   extractCelebInfo(celebDetails, 'debutYear');
  mcd.querySelector('.modal-body input#country').value =     extractCelebInfo(celebDetails, 'country');
  mcd.querySelector('.modal-body input#countryEn').value =   extractCelebInfo(celebDetails, 'countryEn');
  mcd.querySelector('.modal-body input#state').value =       extractCelebInfo(celebDetails, 'state');
  mcd.querySelector('.modal-body input#city').value =        extractCelebInfo(celebDetails, 'city');
  mcd.querySelector('.modal-body input#height').value =      extractCelebInfo(celebDetails, 'height');
  mcd.querySelector('.modal-body input#weight').value =      extractCelebInfo(celebDetails, 'weight');
  mcd.querySelector('.modal-body input#company').value =     extractCelebInfo(celebDetails, 'company');
  mcd.querySelector('.modal-body input#updated').value =     extractCelebInfo(celebDetails, 'updated');

  // 프리뷰 초기화
  clearPreviews()

  // 이미지 로드
  var refId = 'CELEB_'+extractCelebInfo(celebDetails, 'celebSeq');
  loadImages(refId);
});

function extractCelebInfo(raw, key) {
  var keyEqual = key+"=";
  var tempRaw = raw.substring(raw.indexOf(keyEqual), raw.length);
  tempRaw = tempRaw.substring(0, tempRaw.length-1)+",";
  var keyValue = tempRaw.substring(tempRaw.indexOf(keyEqual), tempRaw.indexOf(","));
  return keyValue.replace(keyEqual, "");
};
</script>

<script type="text/javascript">
function loadImages(refId) {
  console.log('fn:loadImages(refId) | redId: '+refId);

  var loadedCelebImages = document.querySelectorAll('.loadedCelebImage');

  if(loadedCelebImages.length > 0) {
    for (var i=0; i<loadedCelebImages.length; i++) {
      console.log('fn:loadImages(refId) | 이전 화면의 이미지 삭제 | div id:'+loadedCelebImages[i].id);
      document.getElementById(loadedCelebImages[i].id).remove();
    }
  }

  $.ajax({
    url: '/image/list/json?refId='+refId,
    type: 'get',
    data: '',
    dataType: 'json',
    cache: false
  })
  .done(function(response) {
    console.log('fn:loadImages(refId) | 이미지 로드 성공');
    if(response.length > 0) {
      $.each(response, function(index, item) {
        $("#celebImages").append(
            '<div class="mx-1 mb-3 loadedCelebImage" id="loadedCelebImage'+index+'">'
            + '<label class="form-label">'
            +     item.originalFilename + ' | ' + item.sizeByte
            + '</label>'
            + '<img id="celebImage'+index+'" src="'+item.resourcePathFilename+'" class="img-fluid" />'
            + '</div>'
        );
      });
    } else {
      $("#celebImages").append(
          '<div class="mx-1 mb-3 loadedCelebImage" id="loadedCelebImage">'
          + '<label class="form-label">등록된 셀럽 이미지가 없습니다.</label>'
          + '</div>'
      );
    }
  })
  .fail(function(xhr, status, errorThrown) {
    console.log('fn:loadImages(refId) | 이미지 로드 실패 | status: '+status);
  });

  //return false;
};
</script>

<!-- Modal: 추가정보 -->
<div class="modal fade" id="modalCelebExt" tabindex="-1" aria-labelledby="modalLabelCelebExt" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">

      <div class="modal-header">
        <h5 class="modal-title" id="modalLabelCelebExt">추가 정보</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>

      <div class="modal-body">
        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="stageName" class="form-label">활동이름*</label>
            <input type="text" class="form-control" id="stageName" readonly>
          </div>
          <div class="col mx-2 mb-3">
            <label for="stageNameEn" class="form-label">활동이름(영문)</label>
            <input type="text" class="form-control" id="stageNameEn" readonly>
          </div>
        </div>
      </div>

      <div class="modal-footer">
        <button class="btn btn-primary" id="backToPrev" data-bs-target="#modalCelebDetails" data-bs-toggle="modal">이전화면</button>
      </div>

    </div>
  </div>
</div>

<script type="text/javascript">
// 추가정보 Modal 화면이 보이는 시점에서의 초기 설정
var mce = document.getElementById('modalCelebExt');
mce.addEventListener('show.bs.modal', function (event) {
  // Button that triggered the modal
  var sourceElement = event.relatedTarget;

  // Extract info from data-bs-* attributes
  var celebDetails = sourceElement.getAttribute('data-bs-celebDetails');

  // Set celebDetails to the trigger buttons
  var buttonBackToPrev = mce.querySelector('.modal-footer button#backToPrev');
  buttonBackToPrev.setAttribute("data-bs-celebDetails", celebDetails);

  // Set modal element value
  mce.querySelector('.modal-body input#stageName').value =   extractCelebInfo(celebDetails, 'stageName');
  mce.querySelector('.modal-body input#stageNameEn').value = extractCelebInfo(celebDetails, 'stageNameEn');
});
</script>
