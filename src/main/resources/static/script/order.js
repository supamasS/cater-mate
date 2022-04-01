/* <div class="form-card col-sm-6">
<label class="form-control-label col-sm-4">Taco Pack</label>
<label class="form-control-label col-sm-4">$20 </label>
</div> */

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
  // td2.appendChild(document.createElement("input"));
  // td3.appendChild(document.createElement("input"));

  tr.appendChild(td0);
  tr.appendChild(td1);
  tr.appendChild(td2);
  tr.appendChild(td3);

  list.appendChild(tr);
});

function check_date(date_input) {
  let re = new RegExp(
    /^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d$/
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
