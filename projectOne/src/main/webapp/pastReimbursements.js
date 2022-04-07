async function viewAllPastTickets(e) {
    e.preventDefault();

    let author = sessionStorage.getItem('username');



    const data = {
        author
    }

    alert(author)

    try {
        let res = await fetch("http://localhost:8080/prjectOne/ViewAllReimbursements", {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        })

    
        let pastTickets = await res.json()
        console.log(pastTickets);

        document.querySelector(".reimbursementHistory").innerHTML = '<ul>' + pastTickets.map(function (pastTickets) {

            return `<li> \u00A0\u00A0\u00A0\u00A0<strong>ID:</strong>${pastTickets.id}
            \u00A0\u00A0\u00A0\u00A0<strong>Amount:</strong> ${pastTickets.amount}
            \u00A0\u00A0\u00A0\u00A0<strong>Submitted:</strong> ${pastTickets.submitted} 
            \u00A0\u00A0\u00A0\u00A0<strong>Resolved:</strong>${pastTickets.resolved}
            \u00A0\u00A0\u00A0\u00A0<strong>Description:</strong> ${pastTickets.description}
            \u00A0\u00A0\u00A0\u00A0<strong>Author:</strong> ${pastTickets.author}
            \u00A0\u00A0\u00A0\u00A0<strong>Resolver:</strong>${pastTickets.resolver}
            \u00A0\u00A0\u00A0\u00A0<strong>Type:</strong>${pastTickets.type}
            \u00A0\u00A0\u00A0\u00A0<strong>Status:</strong> ${pastTickets.status} </li> `
      
          }).join('') + '</ul>';

      
    } catch (error) {
        console.log('Error', error);
        console.log(pastTickets);

    }


}






document.getElementsByTagName("form")[0].addEventListener('submit', viewAllPastTickets);
