{
  /* <div class="form-card col-sm-6">
<label class="form-control-label col-sm-4">Taco Pack</label>
<label class="form-control-label col-sm-4">$20 </label>
</div> */
}

let data = ["Taco Pack", "Burrito Pack", "Enchilada Pack"];

let list = document.getElementById("order_details");

data.forEach((item) => {
  let tr = document.createElement("tr");
  tr.innerText = item;
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
