import { executeJwtAthenticationService } from "../API/AuthenticationApiService";
import { apiClient } from "../API/ApiClient";
import { useContext } from "react";
import { useState ,createContext} from "react";

//create context
export const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);
//const authContext = useContext(AuthContext);
//2:Share the create context with  other component
export default function AuthProvider({ children }) {
  //3:put some state in the context
  const [number, setNumber] = useState(10);
  const [username, setusername] = useState(null);
  const [token, setToken] = useState(null);

  const [isAuthenticated, setAuthenticated] = useState(false);

  const valueToBeShared = { isAuthenticated, login, logout, username,token };

  // function login(username,  password) {

  // }

//   async function login(username, password) {
//     const baToken = "Basic " + window.btoa(username + ":" + password);
// try{
//     const response = await executeBasicAthenticationService(baToken)
      

//     if (response.status==200) {
//       setAuthenticated(true);
//       setusername(username);
//       setToken(baToken)

//       apiClient.interceptors.request.use(
//         (config)=>{
//           console.log('intecepting and adding a token')
//           config.headers.Authorization=baToken
//           return config
//         }
//       )
//       return true
//     } else {
//       logout()

//       return false;
//     }
//   }
//   catch(error){
//     setAuthenticated(false);
//     setusername(null)
//     setToken(null)

//     return false;
//   }
//   }

  async function login(username, password) {
try{
    const response = await executeJwtAthenticationService(username,password)
      

    if (response.status==200) {
      const jwtToken ='Bearer ' + response.data.token
      setAuthenticated(true);
      setusername(username);
      setToken(jwtToken)

      apiClient.interceptors.request.use(
        (config)=>{
      //    console.log('intecepting and adding a token')
          config.headers.Authorization=jwtToken
          return config
        }
      )
      return true
    } else {
      logout()

      return false;
    }
  }
  catch(error){
    logout()

    return false;
  }
  }





  function logout() {
    setAuthenticated(false);
    setusername(null)
    setToken(null)
  }

  return (
    <AuthContext.Provider value={valueToBeShared}>
      {children}
    </AuthContext.Provider>
  );
}
