import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import {
MDBBtn,
MDBContainer,
MDBRow,
MDBCol,
MDBCard,
MDBCardBody,
MDBInput
}
from 'mdb-react-ui-kit';
import './Login.css';


function Login (){
    const navigate = useNavigate();
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const [match, setMatch] = useState(true);

    
    const clickBtn = (e) => {
        e.preventDefault()
        const user = {username, password}
        fetch("http://localhost:8080/users/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                username:username,
                password:password
            })
        }).then(function(response){ 
            return response.json()})
            .then(function(data)
            {console.log(data)
                if(data.username !=null)
                navigate("/user/"+data.username);
                else
                setMatch(false);  
          }).catch(error => console.error('Error:', error)); 
         
       
    }
 
return (
<MDBContainer fluid>

    <MDBRow className='d-flex justify-content-center align-items-center h-100'>
      <MDBCol col='12'>

        <MDBCard className='bg-white my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '500px'}}>
          <MDBCardBody className='p-5 w-100 d-flex flex-column'>

            <h2 className="fw-bold mb-2 text-center">Login</h2>
            <p className="text-white-50 mb-3">Please enter your login and password!</p>
            <div  className={match ? "form_message form_message-error m-hidden " : "form_message form_message-error "}>invalid username or password combination</div>

            <label>Username:</label>
            <MDBInput wrapperClass='mb-4 w-100' placeholder="username"  id='formControlLg' type='text' size="lg"onChange={(e)=>{setUsername(e.target.value);}}/>
            <label>Password:</label>
            <MDBInput wrapperClass='mb-4 w-100'  placeholder="password" type='password' size="lg" onChange={(e)=>{setPassword(e.target.value);}}/>

            <MDBInput type="submit" onClick={clickBtn} placeholder="Login"/>

          </MDBCardBody>
        </MDBCard>

      </MDBCol>
  
    </MDBRow>

  </MDBContainer>
   
)
}

export default Login;
