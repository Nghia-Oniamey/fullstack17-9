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

    // Search 
    const [search, setSearch] = useState({
        productName: "",
        sellPrice: "",
        brandId: "1",
        subCategoryId: "1",
        statusId: "1"
    });

    const { productName, sellPrice, brandId, subCategoryId, statusId } = search;

    const onInputChange = (e) => {

        const { name, value } = e.target;
        setSearch({ ...search, [name]: value });

    };

    const onSubmit = async (e) => {

        e.preventDefault();

        const queryParams = new URLSearchParams({
            productName,
            sellPrice,
            brandId,
            subCategoryId,
            statusId,
        });

        console.log(queryParams);

        const result = await axios.get(`http://localhost:8080/service/products/api/search?${queryParams}`);
        setProducts(result.data);
    };

    return (
        <div className='container mt-4 mb-5'>
            <form onSubmit={(e) => onSubmit(e)}>
                <div className='border rounded p-4 shadow row border-dark'>
                    <div className='mb-3 col'>
                        <label htmlFor='ProductName' className='form-label'>Product Name</label>
                        <input type={'text'} className='form-control' placeholder="Enter Product Name" name='productName'
                            value={productName}
                            onChange={(e) => onInputChange(e)}
                        />
                    </div>
                    <div className='mb-3 col'>
                        <label htmlFor='ProductName' className='form-label'>Sell Price</label>
                        <input type={'number'} className='form-control' placeholder="Enter Sell Price" name='sellPrice'
                            value={sellPrice}
                            onChange={(e) => onInputChange(e)}
                        />
                    </div>

                    <div className='mb-3 col'>
                        <label htmlFor='Brands' className='form-label'>Brands</label>
                        <select className='form-select' aria-label="Default select example"
                            name='brandId'
                            defaultValue={brandId}
                            onChange={(e) => onInputChange(e)}
                        >
                            <option value={1}>1CE</option>
                            <option value={2}>2CE</option>
                            <option value={3}>3CE</option>
                        </select>
                    </div>

                    <div className='mb-3 col'>
                        <label htmlFor='SubCategory' className='form-label'>SubCategory</label>
                        <select className='form-select'
                            name='subCategoryId'
                            defaultValue={subCategoryId}
                            onChange={(e) => onInputChange(e)}
                        >
                            <option value={1}>Mỹ Phẩm 1</option>
                            <option value={2}>Mỹ Phẩm 2</option>
                            <option value={3}>Mỹ Phẩm 3</option>
                        </select>
                    </div>


                    <div className='mb-3 col'>
                        <label htmlFor='Status' className='form-label'>Status</label>
                        <select className='form-select' aria-label="Default select example"
                            name='statusId'
                            defaultValue={statusId}
                            onChange={(e) => onInputChange(e)}
                        >
                            <option value={1}>Còn</option>
                            <option value={2}>Hết</option>
                        </select>
                    </div>
                </div>
                <div className='mb-3 text-center mt-4'>
                    <button type='submit' className='btn btn-dark'>Search</button>
                </div>
            </form>
            <div className='py-4'>
                <table className="table table-hover table-striped border border-dark">
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
                                        <Link className='btn btn-dark mx-2' to={`/viewProduct/${product.id}`}>View</Link>
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
