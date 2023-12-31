$(document).ready(function validate() {
  let flag = false;

  let firstName = function () {
    let fname = $("#fname").val();
    let nameExp = /^[a-zA-Z]{2,8}$/;
    if (fname == "" || fname == undefined) {
      $("#fnameHelp").html("first name is required!").addClass("text-danger");
      return false;
    } else if (nameExp.test(fname) == false) {
      $("#fnameHelp")
        .html(
          "name should have atleat two character and does not contain any digit"
        )
        .addClass("text-danger");
      return false;
    } else {
      $("#fnameHelp").empty();
      return true;
    }
  };

  let lastName = function () {
    let lname = $("#lname").val();
    let nameExp = /^[a-zA-Z]{2,8}$/;
    if (lname == "" || lname == undefined) {
      $("#lnameHelp").html("last name is required!").addClass("text-danger");
      return false;
    } else if (nameExp.test(lname) == false) {
      $("#lnameHelp")
        .html(
          "name should have atleat two character and does not contain any digit"
        )
        .addClass("text-danger");
      return false;
    } else {
      $("#lnameHelp").empty();
      return true;
    }
  };

  let mobileNumber = function () {
    let mobNum = $("#mobile-number").val();
    let mobExp = /^[0-9]{10,11}$/;
    if (mobNum == "" || mobNum == undefined) {
      $("#mobileHelp")
        .html("mobile number is required!")
        .addClass("text-danger");
      return false;
    } else if (mobExp.test(mobNum) == false) {
      $("#mobileHelp")
        .html("enter valid mobile number!")
        .addClass("text-danger");
      return false;
    } else {
      $("#mobileHelp").empty();
      return true;
    }
  };
  let emailAddress = function () {
    let emailExp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    let email = $("#email-address").val();
    if (email == "" || email == undefined) {
      $("#emailHelp").html("email is required!").addClass("text-danger");
      return false;
    } else if (emailExp.test(email) == false) {
      $("#emailHelp")
        .html("Invalid email, email must contain @ (example@xyz.com)!")
        .addClass("text-danger");
      return false;
    } else {
      $("#emailHelp").empty();
      return true;
    }
  };
  let dateOfBirth = function () {
    let dob = $("#dob").val();
    let currentDate = new Date().toISOString().split("T")[0];
    if (dob == "" || dob == undefined) {
      $("#dateHelp").html("enter date of birth!").addClass("text-danger");
      return false;
    } else if (dob > currentDate) {
      $("#dateHelp").html("please enter valid date!").addClass("text-danger");
      return false;
    } else {
      $("#dateHelp").empty();
      return true;
    }
  };
  let resAddress = function () {
    let address = $("#address").val();
    if (address == "" || address == undefined) {
      $("#addressHelp")
        .html("please enter the address!")
        .addClass("text-danger");
      return false;
    } else {
      $("#addressHelp").empty();
      return true;
    }
  };
  let pwd = function () {
    let password = $("#password").val();
    let passwordExp = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
    if (password == "" || password == undefined) {
      $("#passwordHelp").html("password is required!").addClass("text-danger");
      return false;
    } else if (passwordExp.test(password) == false) {
      $("#passwordHelp")
        .html(
          "password should contain atleast 8 characters(one uppercase, one lowercase, one digit and one special character"
        )
        .addClass("text-danger");
      return false;
    } else {
      $("#passwordHelp").empty();
      return true;
    }
  };
  let cnfPassword = function () {
    let password = $("#password").val();
    let cnfPwd = $("#cnf-password").val();
    if (cnfPwd == "" || cnfPwd == undefined) {
      $("#cnfpasswordHelp")
        .html("please re-enter password!")
        .addClass("text-danger");
      return false;
    } else if (cnfPwd != password) {
      $("#cnfpasswordHelp")
        .html("password does not matched!")
        .addClass("text-danger");
      return false;
    } else {
      $("#cnfpasswordHelp").empty();
      return true;
    }
  };
  let gender = function () {
    let selectedGender = $(".gender:checked").val();

    if (selectedGender === undefined) {
      $("#genderHelp").html("please select the gender").addClass("text-danger");
      return false;
    } else {
      $("#genderHelp").empty();
      return true;
    }
  };
  $(".gender").click(function () {

      $("#genderHelp").empty();
  });
  $("#dob").datepicker({
    dateFormat: "yy-mm-dd",
    maxDate: 0,
    changeMonth: true,
    changeYear: true,
    yearRange: "-100:+0"
  });

  $("#calendar-icon").click(function () {
    $("#dob").datepicker("show");
  });
  $("#dob, #calendar-icon").click(function () {
    $("#dateHelp").empty();
  });


  $("#fname").blur(firstName);
  $("#lname").blur(lastName);
  $("#mobile-number").blur(mobileNumber);
  $("#email-address").blur(emailAddress);
  $("#dob").blur(dateOfBirth);
  $("#address").blur(resAddress);
  $("#password").blur(pwd);
  $("#password").blur(gender);
  $("#cnf-password").blur(cnfPassword);
  $("#submit-btn").click(firstName);
  $("#submit-btn").click(lastName);
  $("#submit-btn").click(mobileNumber);
  $("#submit-btn").click(emailAddress);
  $("#submit-btn").click(dateOfBirth);
  $("#submit-btn").click(resAddress);
  $("#submit-btn").click(pwd);
  $("#submit-btn").click(gender);
  $("#submit-btn").click(cnfPassword);
  $("#submit-btn").click(function () {
    let state = $("#state").val();
  });

});
