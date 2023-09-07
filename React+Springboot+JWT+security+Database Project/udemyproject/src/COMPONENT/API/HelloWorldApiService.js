
import axios from 'axios'
import { apiClient } from './ApiClient'
import { executeJwtAthenticationService } from './AuthenticationApiService'
// export function retrieveHelloWorldBean(){
//     return axios.get('http://localhost:8080/hello-world-bean')
// }
// const apiClient = axios.create(
//     {
//         baseURL: 'http://localhost:8080's
//     }
// )


export const retrieveHelloWorldBean 
    = () => apiClient.get('/hello-world-bean')


//Response to preflight request doesn't pass access control check => Authorization header
export const retrieveHelloWorldPathVariable
    = (username,token) => apiClient.get(`/hello-world/path-variable/${username}`,
    //{
    //     headers: {
    //         Authorization:token
    //     }
    // }
    )
    
   