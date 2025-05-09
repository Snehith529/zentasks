import React, { useState } from 'react';
import axios from '../api/axios';
import { useNavigate } from 'react-router-dom';

function LoginPage() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const res = await axios.post('/auth/login', { email, password });
      localStorage.setItem('token', res.data.token);
      navigate('/dashboard');
    } catch (err) {
      console.error('Login error:', err.response?.data || err.message);
      alert('Login failed. Check your email and password.');
    }
  };

  return (
    <div className="min-h-screen bg-gradient-to-r from-blue-50 to-blue-100 flex items-center justify-center">
      <div className="bg-white p-8 rounded shadow-md w-full max-w-md text-center">
        <h2 className="text-2xl font-bold mb-2 text-blue-600">ZenTasks Login</h2>
        <p className="text-sm text-gray-500 mb-6">Securely access your task dashboard</p>
        <input
          type="text"
          placeholder="Email"
          value={email}
          onChange={e => setEmail(e.target.value)}
          className="w-full p-2 border border-gray-300 rounded mb-4"
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={e => setPassword(e.target.value)}
          className="w-full p-2 border border-gray-300 rounded mb-6"
        />
        <button
          onClick={handleLogin}
          className="w-full bg-blue-600 text-white font-semibold py-2 rounded-md shadow hover:bg-blue-700 hover:shadow-md transition duration-200 border border-blue-800"
        >
          Login
        </button>
        <p className="mt-4 text-sm">
          Don't have an account?{' '}
          <span className="text-green-600 cursor-pointer underline" onClick={() => navigate('/register')}>
            Register
          </span>
        </p>
      </div>
    </div>
  );
}

export default LoginPage;