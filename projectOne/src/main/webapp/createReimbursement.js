async function reimbursement(e) {
	e.preventDefault();


	let amount = document.getElementById("user_amountInput").value;
	let type = document.getElementById("user_typeInput").value;
	let description = document.getElementById("user_descriptionInput").value;
	let author = sessionStorage.getItem('username');


	const data = {
		amount,
		type,
		author,
		description
	}

	try {
		let res = await fetch("http://localhost:8080/prjectOne/reimbursement", {
			method: "POST",
			body: JSON.stringify(data),
			headers: {
				"Content-Type": "application/json"
			}
		
		})
		alert("Success")

		let updateAmountStatus = await res.json()
		console.log(updateAmountStatus);

	} 
	catch (error) {
		console.log('Error', error);
		alert("SOMETHING WENT WRONG")
	}



}




document.getElementsByTagName("form")[0].addEventListener('submit', reimbursement);
