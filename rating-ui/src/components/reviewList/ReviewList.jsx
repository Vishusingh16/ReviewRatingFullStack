// ReviewList.js
import React from 'react';
import styles from './ReviewList.module.css';

const ReviewList = ({ reviews }) => {
  return (
    <div className={styles.card}>
      {/* <h2>💬 All Reviews</h2> */}
      {reviews.length === 0 ? (
        <p className={styles.emptyText}> </p>
      ) : (
      <ul className={styles.list}>
        {reviews.map(review => (
          <li key={review.id} className={styles.listItem}>
            {review.imageUrl && <img src={review.imageUrl} alt={`Review by ${review.username}`} className={styles.reviewImage} />}
            <div className={styles.reviewContent}>
              <div className={styles.reviewHeader}>
                <span className={styles.username}>{review.username}</span>
                <span className={styles.rating}>{'⭐'.repeat(review.rating)}</span>
              </div>
              <p className={styles.reviewText}>{review.reviewText || <i>No text provided.</i>}</p>
              <span className={styles.productId}>Product ID: {review.productId}</span>
            </div>
          </li>
        ))}
      </ul>
      )}
    </div>
  );
};

export default ReviewList;