// ProductList.js
import React from 'react';
import styles from './ProductList.module.css'; // Import its own styles

const ProductList = ({ products }) => {
  return (
    <div className={styles.card}>
      <h2>🛒 Product List</h2>
      {products.length === 0 ? (
        <p className={styles.emptyText}>No products found. Add one to get started!</p>
      ) : (
        <ul className={styles.list}>
          {products.map(product => (
            <li key={product.id} className={styles.listItem}>
              <div className={styles.productInfo}>
                <span className={styles.productName}>{product.name}</span>
                <p className={styles.productDescription}>{product.description}</p>
              </div>
              <div className={styles.ratingInfo}>
                <span className={styles.rating}>⭐ {parseFloat(product.averageRating || 0).toFixed(1)}</span>
                <span className={styles.reviewCount}>({product.reviewCount || 0} reviews)</span>
              </div>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default ProductList;