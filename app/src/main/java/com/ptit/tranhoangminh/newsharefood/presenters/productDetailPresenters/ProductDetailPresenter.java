package com.ptit.tranhoangminh.newsharefood.presenters.productDetailPresenters;


import android.content.Context;
import android.graphics.Bitmap;

import com.ptit.tranhoangminh.newsharefood.models.Product;
import com.ptit.tranhoangminh.newsharefood.models.ProductDetail;
import com.ptit.tranhoangminh.newsharefood.views.newProductDetailViews.activities.ProductDetailView;

public class ProductDetailPresenter implements LoadProductDetailListener {
    private ProductDetailView productDetailView;
    private ProductDetailInteractor productDetailInteractor;

    public ProductDetailPresenter(ProductDetailView productDetailView, Context context) {
        this.productDetailView = productDetailView;
        this.productDetailInteractor = new ProductDetailInteractor(this, context);
    }

    public void loadProductDetail(String id, String image_id) {
        productDetailView.showProgress();
        productDetailInteractor.createProductDetail(id, image_id);
        productDetailView.setCheckedSave(productDetailInteractor.isExistItemSQlite(id));
    }

    @Override
    public void onLoadProductDetailSuccess(ProductDetail productDetail, Bitmap bitmap) {
        productDetailView.displayProductDetail(productDetail, bitmap);
        productDetailView.hideProgress();
    }

    @Override
    public void onLoadProductDetailFailure(String message) {
        productDetailView.displayMessage(message);
        productDetailView.hideProgress();
    }

    public void saved(Product product, ProductDetail pDetail, Bitmap bitmap) {
        productDetailInteractor.addProductSqlite(product, pDetail, bitmap);
        productDetailInteractor.setView(product.getId(),1);
    }

    public void unSave(String id) {
        productDetailInteractor.removeProductSqlite(id);
        productDetailInteractor.setView(id,-1);
    }

    @Override
    public void onSaveSuccess(int i) {
        productDetailView.setView(i);
    }

    @Override
    public void onSaveFailure(String message) {
        productDetailView.displayMessage(message);
    }
}
