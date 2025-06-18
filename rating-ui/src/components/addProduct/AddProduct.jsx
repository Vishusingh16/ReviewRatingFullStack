// AddProduct.js
import React, { useState } from 'react';
import axios from 'axios';
import styles from './AddProduct.module.css'; 

// We receive onProductAdded as a prop to call when submission is successful
const AddProduct = ({ onProductAdded }) => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/products', { name, description })
      .then(() => {
        setName('');
        setDescription('');
        onProductAdded(); // Trigger the data refresh in App.js
        alert('✅ Product added!');
      })
      .catch(err => console.error(err));
  };

  return (
    <div className={styles.card}>
      <h2>➕ Add Product</h2>
      <form onSubmit={handleSubmit} className={styles.form}>
        <input className={styles.input} type="text" value={name} placeholder="Product Name" onChange={e => setName(e.target.value)} required />
        <input className={styles.input} type="text" value={description} placeholder="Description" onChange={e => setDescription(e.target.value)} required />
        <button className={styles.button} type="submit">Add Product</button>
      </form>
    </div>
  );
};

export default AddProduct;