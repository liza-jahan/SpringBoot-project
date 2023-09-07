import {BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import LogOutComponent from './OthersComponent/LogOutComponent'
import HeaderComponent from './OthersComponent/HeaderComponent'
import ListTodosComponent from './OthersComponent/ListTodosComponent'
import ErrorComponent from './OthersComponent/ErrorComponent'
import WelcomeComponent from './OthersComponent/WelcomeComponent'
import LoginComponent from './OthersComponent/LoginComponent'
import TodoComponent from './API/TodoComponent'
import AuthProvider, { useAuth } from './security/AuthContext'

import './form.module.css'

function AuthenticatedRoute({children}) {
    const authContext = useAuth()
    
    if(authContext.isAuthenticated)
        return children

    return <Navigate to="/" />
}

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent />
                    <Routes>
                        <Route path='/' element={ <LoginComponent /> } />
                        <Route path='/login' element={ <LoginComponent /> } />
                        
                        <Route path='/welcome/:username' element={
                            <AuthenticatedRoute>
                                <WelcomeComponent />
                            </AuthenticatedRoute> 
                        } />
                        
                        <Route path='/todos' element={
                            <AuthenticatedRoute>
                                <ListTodosComponent /> 
                            </AuthenticatedRoute>
                        } />

                        <Route path='/todo/:id' element={
                            <AuthenticatedRoute>
                                <TodoComponent /> 
                            </AuthenticatedRoute>
                        } />
  

                        <Route path='/logout' element={
                            <AuthenticatedRoute>
                                <LogOutComponent /> 
                            </AuthenticatedRoute>
                        } />
                        
                        <Route path='*' element={<ErrorComponent /> } />

                    </Routes>
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}
