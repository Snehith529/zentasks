// import React, { useEffect, useState } from 'react';
// import axios from '../api/axios';

// function Dashboard() {
//   const [tasks, setTasks] = useState([]);
//   const [title, setTitle] = useState('');
//   const [description, setDescription] = useState('');

//   useEffect(() => {
//     axios.get('/tasks/user/1') // static user ID for demo
//       .then(res => setTasks(res.data))
//       .catch(console.error);
//   }, []);

//   const handleCreateTask = async () => {
//     try {
//       const payload = { title, description, userId: 1, tagIds: [1] }; // sample static tag
//       await axios.post('/tasks', payload);
//       alert('Task created!');
//       window.location.reload();
//     } catch (err) {
//       alert('Error creating task');
//     }
//   };

//   return (
//     <div className="min-h-screen bg-gray-50 p-8">
//       <h1 className="text-3xl font-semibold text-blue-600 mb-6">ZenTasks Dashboard</h1>

//       <div className="bg-white p-4 rounded shadow-md mb-6 flex flex-col sm:flex-row gap-4">
//         <input
//           type="text"
//           placeholder="Title"
//           value={title}
//           onChange={e => setTitle(e.target.value)}
//           className="flex-1 border border-gray-300 p-2 rounded"
//         />
//         <input
//           type="text"
//           placeholder="Description"
//           value={description}
//           onChange={e => setDescription(e.target.value)}
//           className="flex-1 border border-gray-300 p-2 rounded"
//         />
//         <button
//           onClick={handleCreateTask}
//           className="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700 transition"
//         >
//           Add
//         </button>
//       </div>

//       <ul className="space-y-3">
//         {tasks.map(task => (
//           <li key={task.id} className="bg-white p-4 rounded shadow border-l-4 border-blue-500">
//             <h3 className="font-semibold text-lg">{task.title}</h3>
//             <p className="text-gray-600">{task.description}</p>
//           </li>
//         ))}
//       </ul>
//     </div>
//   );
// }

// export default Dashboard;


// --- src/pages/Dashboard.js ---
import React, { useEffect, useState } from 'react';
import axios from '../api/axios';

function Dashboard() {
  const [tasks, setTasks] = useState([]);
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');

  useEffect(() => {
    axios.get('/tasks/user/1')
      .then(res => setTasks(res.data))
      .catch(console.error);
  }, []);

  const handleCreateTask = async () => {
    try {
      const payload = { title, description, userId: 1, tagIds: [1] };
      await axios.post('/tasks', payload);
      alert('Task created!');
      window.location.reload();
    } catch (err) {
      alert('Error creating task');
    }
  };

  return (
    <div className="min-h-screen bg-gradient-to-r from-green-50 to-green-100 p-8 flex flex-col items-center">
      <div className="w-full max-w-2xl">
        <h1 className="text-3xl font-semibold text-green-700 text-center mb-2">ZenTasks Dashboard</h1>
        <p className="text-center text-sm text-gray-600 mb-6">Manage your tasks with clarity and ease</p>

        <div className="bg-white p-4 rounded shadow-md mb-6 flex flex-col sm:flex-row gap-4">
          <input
            type="text"
            placeholder="Title"
            value={title}
            onChange={e => setTitle(e.target.value)}
            className="flex-1 border border-gray-300 p-2 rounded"
          />
          <input
            type="text"
            placeholder="Description"
            value={description}
            onChange={e => setDescription(e.target.value)}
            className="flex-1 border border-gray-300 p-2 rounded"
          />
          <button
            onClick={handleCreateTask}
            className="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700 transition"
          >
            Add
          </button>
        </div>

        <ul className="space-y-3">
          {tasks.map(task => (
            <li key={task.id} className="bg-white p-4 rounded shadow border-l-4 border-green-500">
              <h3 className="font-semibold text-lg">{task.title}</h3>
              <p className="text-gray-600">{task.description}</p>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default Dashboard;