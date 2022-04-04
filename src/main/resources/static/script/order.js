let data = [
  ["Taco Pack", 35],
  ["Burrito Pack", 32],
  ["Enchilada Pack", 39],
];

let list = document.getElementById("menu");

data.forEach((item) => {
  let tr = document.createElement("tr");
  let td0 = document.createElement("td");
  let td1 = document.createElement("td");
  let td2 = document.createElement("td");
  let td3 = document.createElement("td");

  td0.innerText = item[0];
  td1.innerText = item[1];
  td2.appendChild(document.createElement("input"));
  td3.appendChild(document.createElement("input"));

  tr.appendChild(td0);
  tr.appendChild(td1);
  tr.appendChild(td2);
  tr.appendChild(td3);

  list.appendChild(tr);
});

let ele = document.getElementById("feedback");

function validate() {
  let cateringDate = document.getElementById("cateringDate");

  if (cateringDate.value == undefined || cateringDate.value == "") {
    alert("Please provide Catering Date!");
    cateringDate.focus();
    return false;
  } else if (!check_date(cateringDate.value)) {
    alert("Invalid Catering Date!");
    cateringDate.focus();
    return false;
  }

  let readyTime = document.getElementById("readyTime");

  if (readyTime.value == undefined || readyTime.value == "") {
    alert("Please provide Kitchen Ready Time!");
    readyTime.focus();
    return false;
  } else if (!check_time(readyTime.value)) {
    alert("Please provide Kitchen Ready Time in the correct format!");
    readyTime.focus();
    return false;
  }

  return true;
}

function check_date(date_input) {
  let re = new RegExp(
    /^20\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$/
  );
  let message = "";
  let someWrong = false;
  if (!re.test(date_input)) {
    message += "Date entered is not in the right format";
    someWrong = true;
  }
  if (someWrong) {
    let para = document.createElement("P");
    para.classList.add("danger");
    let t = document.createTextNode(message);
    para.appendChild(t);

    ele.appendChild(para);
    return false;
  }
  return true;
}

function check_time(time_input) {
  let re = new RegExp(/^([0-1]\d|2[0-3]):[0-5]\d$/);
  let message = "";
  let someWrong = false;
  if (!re.test(time_input)) {
    message += "Time entered is not in the right format";
    someWrong = true;
  }
  if (someWrong) {
    let para = document.createElement("P");
    para.classList.add("danger");
    let t = document.createTextNode(message);
    para.appendChild(t);

    ele.appendChild(para);
    return false;
  }
  return true;
}
