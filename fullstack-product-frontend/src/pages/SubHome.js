import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function SubHome() {
    
    const [products, setProducts] = useState([])
    useEffect(() => {
        loadProduct();
    }, []);

    const loadProduct = async () => {
        const result = await axios.get("http://localhost:8080/service/products");
        setProducts(result.data);
        console.log(result.data);
    };

    return (
        <div className='container'>
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

                                <tr>
                                    <th scope="row" key={index}>{index + 1}</th>
                                    <td>{product.productName}</td>
                                    <td>
                                        {product.brands.map(brand => (
                                            <td class="d-grid gap-2" key={brand.id}>{brand.brandName}</td>
                                        ))}
                                    </td>
                                    <td>{product.subCategory.category.cateName}</td>
                                    <td>{product.sellPrice}</td>
                                    <td>{product.status.statusName}</td>
                                    <td>
                                        <button className='btn btn-primary mx-2'>View</button>
                                        <button className='btn btn-outline-primary mx-2'>Edit</button>
                                        <button className='btn btn-danger mx-2'>Delete</button>
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
