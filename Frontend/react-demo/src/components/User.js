import axios from "axios";
import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import './User.css';

function User () {
    const [user, setUser] = useState({}); 
    const {username} = useParams()

    useEffect(() => {
        axios
          .get(`http://localhost:8080/users/${username}`)
          .then((response) => setUser(response.data))
          .catch((error) => console.log(error));
      
    },[user]);

      
      return(
        <>
        
        <div class="container">
            <div class="main-body">
            <h2>Profile Information</h2>
                <div class="col-md-8">
                    <div class="card mb-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Username:</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    {user.username}
                                </div>
                            </div>
                            <hr/>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Password</h6>
                                </div>
                                    <div class="col-sm-9 text-secondary">
                                    {user.password}
                                    </div>
                            </div>
                            <hr/>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Roles</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <ul>
                                        {user.assignedRoles ? user.assignedRoles.map((e)=>{
                                            return( 
                                            <li> {e.roleType}</li> 
                                            ) 
                                        }):""}
                                    </ul> 
                                </div>
                            </div>
                            <hr/>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Permissions</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                {user.assignedRoles ? user.assignedRoles.map((e)=>{
                                    return( 
                                    <>
                                    <ul>
                                        {e.permissionList?e.permissionList.map((e)=>{
                                            return (
                                            <li>{e.permissionType}</li>
                                            )
                                        }):""}
                                    </ul>
                                    </>
                                    )
                                }):""}
                                <ul>
                                    {user.permissionList ? user.permissionList.map((e)=>{
                                        return  <li>{e.permissionType}</li>
                                        }):""}    
                                </ul> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </>
    )


}
     
export default User;

