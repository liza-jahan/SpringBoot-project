import { apiClient } from "./ApiClient"

export const executeBasicAthenticationService
= (token) => apiClient.get(`/basicauth`
,{
    headers: {
        Authorization: token
    }
}
)


export const executeJwtAthenticationService
= (username,password) => 
apiClient.post(`/authenticate`,{ username,password})