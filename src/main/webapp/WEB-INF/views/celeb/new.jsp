<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal: 신규등록 -->
<div class="modal fade" id="modalNewCeleb" data-bs-backdrop="static" tabindex="-1" aria-labelledby="modalLabelNewCeleb" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <h5 class="modal-title" id="modalLabelNewCeleb">셀럽 정보</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>

      <form id="formNewCeleb" name="newCeleb">

      <div class="modal-body">

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="celebCode" class="form-label">셀럽구분</label>
            <select class="form-select" id="celebCode" name="celebCode">
              <option value="ACT">배우</option>
              <option value="SIN">가수</option>
              <option value="UND" selected>미확인</option>
            </select>
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="stageName" class="form-label">활동이름*</label>
            <input type="text" class="form-control" id="stageName" name="stageName" placeholder="김이박">
          </div>
          <div class="col mx-2 mb-3">
            <label for="stageNameEn" class="form-label">활동이름(영문)</label>
            <input type="text" class="form-control" id="stageNameEn" name="stageNameEn" placeholder="Leepark Kim">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="realName" class="form-label">실제이름</label>
            <input type="text" class="form-control" id="realName" name="realName" placeholder="김이박">
          </div>
          <div class="col mx-2 mb-3">
            <label for="realNameEn" class="form-label">실제이름(영문)</label>
            <input type="text" class="form-control" id="realNameEn" name="realNameEn" placeholder="Leepark Kim">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="gender" class="form-label">성별</label>
            <div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderF" value="F">
                <label class="form-check-label" for="genderF">여성</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderM" value="M">
                <label class="form-check-label" for="genderM">남성</label>
              </div>
              <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderO" value="O" checked>
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
              <input type="date" class="form-control datePicker" id="birthDate" name="birthDate" value="" readonly>
            </div>
          </div>
          <div class="col mx-2 mb-3">
            <label for="debutYear" class="form-label">데뷔년도</label>
            <input type="number" class="form-control" id="debutYear" name="debutYear" min='1900' max='2040' step='1' placeholder="1983">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="country" class="form-label">국가</label>
            <input type="text" class="form-control" id="country" name="country" placeholder="대한민국" value="대한민국">
          </div>
          <div class="col mx-2 mb-3">
            <label for="countryEn" class="form-label">국가(영문)</label>
            <input type="text" class="form-control" id="countryEn" name="countryEn" placeholder="South Korea" value="South Korea">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="state" class="form-label">시/도</label>
            <input type="text" class="form-control" id="state" name="state" placeholder="서울">
          </div>
          <div class="col mx-2 mb-3">
            <label for="city" class="form-label">시/군/구</label>
            <input type="text" class="form-control" id="city" name="city" placeholder="송파구">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="height" class="form-label">키</label>
            <input type="number" class="form-control" id="height" name="height" min='100' max='300' step='0.01' placeholder="177.6">
          </div>
          <div class="col mx-2 mb-3">
            <label for="weight" class="form-label">무게</label>
            <input type="number" class="form-control" id="weight" name="weight" min='50' max='250' step='0.01' placeholder="77.6">
          </div>
        </div>

        <div class="row">
          <div class="col mx-2 mb-3">
            <label for="company" class="form-label">소속사</label>
            <input type="text" class="form-control" id="company" name="company" placeholder="니베아 엔터테인먼트">
          </div>
        </div>

      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="registerCeleb">신규 등록</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>

      </form>  <!-- form id="formNewCeleb" -->

    </div>
  </div>
</div>

<!-- Script: datePicker 초기설정 -->
<script type="text/javascript">
var datePickerDefaults = {
  format: "yyyy-mm-dd",                           //데이터 형식(yyyy: 년, mm: 월, dd: 일)
  autoclose: true,                                //사용자가 날짜를 클릭하면 캘린더가 자동으로 종료되는 옵션
  calendarWeeks: false,                           //캘린더 옆에 몇 주차인지 보여주는 옵션. 기본값: false. 보여주려면 true
  clearBtn: true,                                 //선택한 날짜 값 초기화 옵션. 기본값: false. 보여주려면 true
  //datesDisabled: ['2019-06-24', '2019-06-26'],  //선택 불가능한 날짜 범위 설정
  //daysOfWeekDisabled: [0, 6],                   //선택 불가능한 요일 설정. 0: 일요일 ~ 6: 토요일
  //daysOfWeekHighlighted: [3],                   //강조할 요일 설정
  disableTouchKeyboard: false,                    //모바일에서 플러그인 작동 여부. 기본값 false=작동, true=작동X
  immediateUpdates: false,                        //날짜 선택 시 바로 업데이트 처리 여부. 기본값: false
  multidate: false,                               //여러 날짜 선택 활성화 옵션. 기본값: false
  multidateSeparator:',',                         //여러 날짜 선택 시 날짜 값 사이 구분기호. 2019-05-01,2019-06-01
  templates: {                                    //다음달/이전달로 화살표 모양 커스텀 마이징
      leftArrow: '◀',
      rightArrow: '▶'
  },
  showWeekDays: true,                             //요일 보여주는 옵션. 기본값: true
  title: '날짜 선택',                              //캘린더 상단 타이틀
  todayHighlight: true,                           //오늘 날짜에 하이라이트. 기본값: false
  toggleActive: true,                             //이미 선택된 날짜 선택 시 삭제 처리. 기본값: false
  weekStart: 0,                                   //달력 시작 요일. 기본값: 0 일요일
  language: 'ko'                                  //언어 선택. 선택한 언어ㅔ 맞는 js로 변경 필요
};
</script>

<!-- Script: Modal-신규등록 초기설정 -->
<script type="text/javascript">
$('#formNewCeleb #birthDate').datepicker(datePickerDefaults);

$('#formNewCeleb').on('click', '#registerCeleb', function() {
  var stageName = document.getElementById('formNewCeleb').querySelector('.modal-body input#stageName').value;
  var $form = $('#formNewCeleb');
  //console.log($form.serialize());

  $.ajax({
      url: '/celeb/register/json',
      type: 'post',
      data: $form.serialize(),
      dataType: 'json',
      success: function(response) {
          console.log(response);

          if (response.code == 'SUCCESS') {
            alert('신규등록 완료:)');
            location.href = '/celeb/list?keyword='+stageName;
          } else {
              alert(response.message);
          }
      }
  });

  //return false;
});
</script>
