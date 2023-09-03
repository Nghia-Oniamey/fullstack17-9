import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';

export default function ViewProduct() {

    const { id } = useParams()

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
        const { name, value } = e.target;

        if (name === 'subCategory') {
            setProduct({ ...product, [name]: { id: value } });
        } else if (name === 'brands') {
            setProduct({ ...product, [name]: [{ id: value }] });
        }
        else {
            setProduct({ ...product, [name]: value });
        }

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
                    <h2 className='text-center m-4 '>View Product</h2>
                    <form>

                        <div className='mb-3'>
                            <label htmlFor='ProductName' className='form-label'>Product Name</label>
                            <input disabled type={'text'} className='form-control' placeholder="Enter Product Name" name='productName'
                                value={productName}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='ProductColor' className='form-label'>Product Color</label>
                            <input disabled type={'text'} className='form-control' placeholder="Enter Product Color" name='color'
                                value={color}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='ProductQuatity' className='form-label'>Product Quatity</label>
                            <input disabled type={'text'} className='form-control' placeholder="Enter Product Quatity" name='quantity'
                                value={quantity}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='ProductSellPrice' className='form-label'>Product Sell Price</label>
                            <input disabled type={'text'} className='form-control' placeholder="Enter Sell Price" name='sellPrice'
                                value={sellPrice}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='ProductOriginPrice' className='form-label'>Product Origin Price</label>
                            <input disabled type={'text'} className='form-control' placeholder="Enter Subcategory" name='originPrice'
                                value={originPrice}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='SubCategory' className='form-label'>SubCategory</label>
                            <select disabled className='form-select' name='subCategory' value={subCategory.id} onChange={(e) => onInputChange(e)}>
                                <option value={1}>Mỹ Phẩm 1</option>
                                <option value={2}>Mỹ Phẩm 2</option>
                                <option value={3}>Mỹ Phẩm 3</option>
                            </select>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='Brands' className='form-label'>Brands</label>
                            <select disabled className='form-select' aria-label="Default select example" name='brands' value={brands[0].id} onChange={(e) => onInputChange(e)}>
                                <option value={1}>1CE</option>
                                <option value={2}>2CE</option>
                                <option value={3}>3CE</option>
                            </select>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='Status' className='form-label'>Status</label>
                            <select disabled className='form-select' aria-label="Default select example" name='status' value={status.id} onChange={(e) => onInputChange(e)}>
                                <option value={1}>Còn</option>
                                <option value={2}>Hết</option>
                            </select>
                        </div>

                        <div className='mt-4'>
                            <Link className='btn btn-danger mx-2' to={"/"}>Cancel</Link>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    )
}
