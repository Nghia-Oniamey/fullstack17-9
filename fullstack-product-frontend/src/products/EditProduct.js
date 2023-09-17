import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';

export default function EditProduct() {

    const { id } = useParams()

    const [statuses, setStatus] = useState([]);
    const [brandss, setBrand] = useState([]);
    const [subCategories, setSubCategory] = useState([]);

    const loadBrand = async () => {
        const result = await axios.get("http://localhost:8080/brand");
        setBrand(result.data);
    };

    const loadStatus = async () => {
        const result = await axios.get("http://localhost:8080/status");
        setStatus(result.data);
    };

    const loadSubcategory = async () => {
        const result = await axios.get("http://localhost:8080/sub-category");
        setSubCategory(result.data);
    }

    useEffect(() => {
        loadSubcategory();
        loadBrand();
        loadStatus();
    }, []);

    let navigate = useNavigate();

    const [product, setProduct] = useState({
        productName: "",
        color: "",
        quantity: "",
        sellPrice: "",
        originPrice: "",
        description: "",
        subCategory: {
            id: 1
        },
        status: {
            id: 1
        },
        brands: [
            {
                id: 1
            }
        ]
    });

    const { productName, color, quantity, sellPrice, originPrice, subCategory, brands, status } = product;

    const onInputChange = (e) => {

        // setProduct({ ...product, [e.target.name]: e.target.value });
        // // or
        const { name, value } = e.target;
        // setProduct({ ...product, [name]: productName});

        if (name === 'subCategory') {
            setProduct({ ...product, [name]: { id: value } });
        } else if (name === 'status') {
            setProduct({ ...product, [name]: { id: value } });
        }
        else if (name === 'brands') {
            setProduct({ ...product, [name]: [{ id: value }] });
        }
        else {
            setProduct({ ...product, [name]: value });
        }

    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.put(`http://localhost:8080/service/product/${id}`, product);
        navigate("/");
    };

    useEffect(() => {
        loadProduct();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    const loadProduct = async () => {
        const result = await axios.get(`http://localhost:8080/service/product/${id}`)
        setProduct(result.data)
    };

    return (
        <div className='container mt-4'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4 '>Edit Product</h2>
                    <form onSubmit={(e) => onSubmit(e)}>

                        <div className='mb-3'>
                            <label htmlFor='ProductName' className='form-label'>Product Name</label>
                            <input type={'text'} className='form-control' placeholder="Enter Product Name" name='productName'
                                value={productName}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='ProductColor' className='form-label'>Product Color</label>
                            <input type={'text'} className='form-control' placeholder="Enter Product Color" name='color'
                                value={color}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='ProductQuatity' className='form-label'>Product Quatity</label>
                            <input type={'text'} className='form-control' placeholder="Enter Product Quatity" name='quantity'
                                value={quantity}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='ProductSellPrice' className='form-label'>Product Sell Price</label>
                            <input type={'text'} className='form-control' placeholder="Enter Sell Price" name='sellPrice'
                                value={sellPrice}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='ProductOriginPrice' className='form-label'>Product Origin Price</label>
                            <input type={'text'} className='form-control' placeholder="Enter Subcategory" name='originPrice'
                                value={originPrice}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='SubCategory' className='form-label'>SubCategory</label>
                            <select className='form-select' name='subCategory' value={subCategory.id} onChange={(e) => onInputChange(e)}>
                                {
                                    subCategories.map((subCategory) => (
                                        <option key={subCategory.id} value={subCategory.id}>
                                            {subCategory.subCateName}
                                        </option>
                                    ))
                                }
                            </select>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='Brands' className='form-label'>Brands</label>
                            <select className='form-select' aria-label="Default select example" name='brands' value={brands[0].id} onChange={(e) => onInputChange(e)}>
                                {
                                    brandss.map((brand) => (
                                        <option key={brand.id} value={brand.id}>
                                            {brand.brandName}
                                        </option>
                                    ))
                                }
                            </select>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='Status' className='form-label'>Status</label>
                            <select className='form-select' aria-label="Default select example" name='status' value={status.id} onChange={(e) => onInputChange(e)}>
                                {
                                    statuses.map((status) => (
                                        <option key={status.id} value={status.id}>
                                            {status.statusName}
                                        </option>
                                    ))
                                }
                            </select>
                        </div>

                        <div className='mt-4'>
                            <button type='submit' className='btn btn-primary'>Save</button>

                            <Link className='btn btn-danger mx-2' to={"/"}>Cancel</Link>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    )
}
