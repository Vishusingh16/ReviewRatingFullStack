import React, { useState, useEffect, useCallback } from 'react';
import axios from 'axios';
import ProductList from './components/productList/ProductList';
import AddProduct from './components/addProduct/AddProduct';
import AddReview from './components/addReview/AddReview';
import ReviewList from './components/reviewList/ReviewList';
import './App.css'; // Import layout styles

function App() {
  const [products, setProducts] = useState([]);
  const [reviews, setReviews] = useState([]);

  // Use useCallback to prevent re-creating these functions on every render
  const fetchProducts = useCallback(async () => {
    try {
      const res = await axios.get('http://localhost:8080/api/products');
      setProducts(res.data);
    } catch (err) {
      console.error("Failed to fetch products:", err);
    }
  }, []);

  const fetchReviews = useCallback(async () => {
    try {
      const res = await axios.get('http://localhost:8080/api/reviews');
      setReviews(res.data);
    } catch (err) {
      console.error("Failed to fetch reviews:", err);
    }
  }, []);


  // Fetch initial data on component mount
  useEffect(() => {
    fetchProducts();
    fetchReviews();
  }, [fetchProducts, fetchReviews]);

  // This function will be called by child components to trigger a refresh
  const handleDataUpdate = () => {
    fetchProducts();
    fetchReviews();
  };

  return (
    <div className="container">
      <h1>📦 Product Ratings & Reviews</h1>
      <main className="main-content">
        <section className="forms-column">
          <AddProduct onProductAdded={handleDataUpdate} />
          <AddReview products={products} onReviewAdded={handleDataUpdate} />
        </section>
        <section className="lists-column">
          <ProductList products={products} />
          <ReviewList reviews={reviews} />
        </section>
      </main>
    </div>
  );
}

export default App;