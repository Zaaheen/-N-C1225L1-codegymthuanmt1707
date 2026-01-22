function convert() {
  let amount = +document.getElementById("amount").value;
  let from = document.getElementById("fromCurr").value;
  let to = document.getElementById("toCurr").value;
  let result = 0;

  if (from === "VND" && to === "USD") {
    result = amount / 26300;
    document.getElementById("result").innerText = "Result: " + result.toFixed(5) + " USD";
  }
  else if (from === "USD" && to === "VND") {
    result = amount * 26300;
    document.getElementById("result").innerText = "Result: " + result.toLocaleString() + " VND";
  }
  else {
    document.getElementById("result").innerText = "Result: " + amount + " " + to;
  }
}
