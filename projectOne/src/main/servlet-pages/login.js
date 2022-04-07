async function loginSubmit(e){
    e.preventDefault();

    let username = document.getElementById("username-input").value
    let password = document.getElementById("password-input").value

    //enhanced object literals
    const credentials = {
        username,
        password
    }

    try{
        let res = await fetch("http://localhost:8080/projectone/servlet-pages/index.html",{
            method:"POST",
            redirect: "follow",
            body: JSON.stringify(credentials),
            headers:{
                "Content-Type" : "application/json"
            }
        })
        let user = await res.json()
        console.log(user);
        console.log(user.user_role);
        if(user.user_role === "Employee"){
            sessionStorage.setItem('userId', user.users_id);
			window.location = "./employeeMain.html"
		
        }else if(user.user_role === "Finance manager"){
            window.location = "./financeManagerMain.html"
        }
    } catch(e) {
        console.log(e);
    }
}
document.getElementsByTagName("form")[0].addEventListener('submit', loginSubmit)
