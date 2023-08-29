import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function SubHome() {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        loadProduct();
    }, []);

    const loadProduct = async () => {
        const result = await axios.get("http://localhost:8080/service/products");
        setProducts(result.data);
    };

    const deleteProduct = async (id) => {
        await axios.delete(`http://localhost:8080/service/product/${id}`);
        loadProduct();
    }

    return (
        <div className='container mt-4'>
            <div className='py-4'>
                <table className="table table-hover table-striped">
                    <thead className='table-dark'>
                        <tr>
                            <th scope="col">No</th>
                            <th scope="col">Product Name</th>
                            <th scope="col">Brand Name</th>
                            <th scope="col">SubCategory</th>
                            <th scope="col">Price</th>
                            <th scope="col">Status</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody className='table-group-divider'>
                        {
                            products.map((product, index) => (

                                <tr key={product.id}>
                                    <th scope="row" key={index}>{index + 1}</th>
                                    <td>{product.productName}</td>
                                    <td>
                                        {product.brands.map(brand => (
                                            <div className="d-grid gap-2" key={brand.id}>{brand.brandName}</div>
                                        ))}
                                    </td>
                                    <td>{product.subCategory.category.cateName}</td>
                                    <td>{product.sellPrice}</td>
                                    <td>{product.status.statusName}</td>
                                    <td>
                                        <Link className='btn btn-primary mx-2' to={`/viewProduct/${product.id}`}>View</Link>
                                        <Link className='btn btn-outline-primary mx-2' to={`/editProduct/${product.id}`}>Edit</Link>
                                        <button onClick={() => deleteProduct(product.id)} className='btn btn-danger mx-2'>Delete</button>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}
