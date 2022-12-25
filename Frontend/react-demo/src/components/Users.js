import UserList from "./UserList";
import axios from "axios";
import { useState, useEffect } from "react";
import Table from 'react-bootstrap/Table';
function Users (){

    const [allUsers ,setAllUsers] = useState([]);
    useEffect(() => {
        axios
          .get("http://localhost:8080/users")
          .then((response) => setAllUsers(response.data))
          .catch((error) => console.log(error));
      
      },[allUsers]);

      console.log(allUsers);

return(
  <>
  <Table  striped bordered hover size="sm">
          <thead>
            <tr>
              <th>ID</th>
              <th>Username</th>
              <th>Password</th>
              <th>Roles</th>
              <th>Permissions</th>
            </tr>
          </thead>
          
          <tbody>
      {allUsers.map((element)=>{
       return(
        <>
 
          <UserList user={element}/>
         </>
        )
        })} 
          </tbody>
  </Table>
</>
)
}
export default Users;