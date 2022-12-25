import Table from 'react-bootstrap/Table';
function UserList ({user}) {
  
  
    return (

            <tr>
              <td>{user.id}</td>
              <td>{user.username}</td>
              <td>{user.password}</td>
              <td>
              <ul>
            {user.assignedRoles ? user.assignedRoles.map((e)=>{
                return( 
                <li> {e.roleType}</li> 
                ) 
               
            }):""}
              </ul> 
              </td>
              <td>
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
                return  <li>{e.permissionType}</li>}):""}    
                </ul> 
                </td> 
            </tr>
    );
    
}
     
export default UserList;