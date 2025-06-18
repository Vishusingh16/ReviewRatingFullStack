// AddReview.js
import React, { useState } from 'react';
import axios from 'axios';
import styles from '../addProduct/AddProduct.module.css';  

const AddReview = ({ products, onReviewAdded }) => {
  const [productId, setProductId] = useState('');
  const [username, setUsername] = useState('');
  const [rating, setRating] = useState('');
  const [reviewText, setReviewText] = useState('');
  const [imageUrl, setImageUrl] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/reviews/add', {
      productId :  parseInt(productId, 10), username, rating: parseInt(rating), reviewText, imageUrl
    })
    .then(() => {
      setProductId(''); setUsername(''); setRating(''); setReviewText(''); setImageUrl('');
      onReviewAdded(); 
      alert('✅ Review submitted!');
    })
    .catch(err => console.error(err));
  };

  return (
    <div className={styles.card}>
      <h2>📝 Add Review</h2>
      <form onSubmit={handleSubmit} className={styles.form}>
        <select className={styles.select} value={productId} onChange={e => setProductId(e.target.value)} required>
            <option value="" disabled>-- Select a Product --</option>
            {products.map(p => (
                <option key={p.id} value={p.id}>{p.name}</option>
            ))}
        </select>
        <input className={styles.input} type="text" value={username} placeholder="Your Name" onChange={e => setUsername(e.target.value)} required />
        <input className={styles.input} type="number" min="1" max="5" value={rating} placeholder="Rating (1-5)" onChange={e => setRating(e.target.value)} required/>
        <textarea className={styles.textarea} value={reviewText} placeholder="Review Text" onChange={e => setReviewText(e.target.value)} />
        <input className={styles.input} type="text" value={imageUrl} placeholder="Image URL (optional)" onChange={e => setImageUrl(e.target.value)} />
        <button className={styles.button} type="submit">Submit Review</button>
      </form>
    </div>
  );
};

export default AddReview;