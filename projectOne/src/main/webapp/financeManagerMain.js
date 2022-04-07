async function viewAllTickets(e) {
    e.preventDefault();
    

    try {
        let res = await fetch("http://localhost:8080/prjectOne/ViewAllByManager", {
            method: "POST",
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

    }


}

async function viewAllApproved(e) {
    e.preventDefault();


    let filter = "approved"

    const data = {
        filter
    }


    try {
        let res = await fetch("http://localhost:8080/prjectOne/FilterRequests", {
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

    }


}


async function viewAllPending(e) {
    e.preventDefault();


    let filter = "pending"

    const data = {
        filter
    }


    try {
        let res = await fetch("http://localhost:8080/prjectOne/FilterRequests", {
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

    }


}
async function ViewAllDenied(e) {
    e.preventDefault();


    let filter = "denied"

    const data = {
        filter
    }


    try {
        let res = await fetch("http://localhost:8080/prjectOne/FilterRequests", {
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

    }


}

async function acceptReimbursement(e) {
    e.preventDefault();
    
    let resolver = sessionStorage.getItem('username');
    let status = "approved";
    let id = document.getElementById("id_input").value;


    const data = {
        status,
        resolver,
        id

    }
alert(id)


    try {
        let res = await fetch("http://localhost:8080/prjectOne/updateReimbursement", {
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

    }


}

async function denyReimbursement(e) {
    e.preventDefault();




    let status = "denied";
    let resolver = sessionStorage.getItem('username');
    let id = document.getElementById("id_input").value;


    const data = {
        status,
        id,
        resolver

    }


    try {
        let res = await fetch("http://localhost:8080/prjectOne/updateReimbursement", {
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

    }


}





document.getElementById("viewall").addEventListener('click',viewAllTickets);
document.getElementById("approved").addEventListener('click',viewAllApproved);
document.getElementById("pending").addEventListener('click',viewAllPending);
document.getElementById("denied").addEventListener('click',ViewAllDenied);
document.getElementById("accept").addEventListener('click',acceptReimbursement);
document.getElementById("deny").addEventListener('click',denyReimbursement);
