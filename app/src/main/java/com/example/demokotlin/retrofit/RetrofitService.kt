package com.example.demokotlin.retrofit

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RetrofitService {
    companion object : RequestMethod {
        private lateinit var apiInterface: ApiInterface
        private lateinit var responseServer: ResponseServer
        fun RetrofitService(responseServer: ResponseServer) {
            apiInterface = RetrofitClient.getClient().create(ApiInterface::class.java)
            this.responseServer = responseServer
        }

        override fun get(url: String) {
//        apiInterface.run {
//            getCurrency()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ result -> println(result.getData()) },
//                    { error -> println(error.message) })
            apiInterface.getCurrency()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<BaseResponse> {
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: BaseResponse) {
                        when (t.code) {
                            2007 -> responseServer.success(t.getData())
                            200 -> responseServer.success()
                            400 -> responseServer.error()
                        }
                    }

                    override fun onError(e: Throwable) {
                        responseServer.error()
                    }

                })

//        apiInterface.getSomething().enqueue(object : retrofit2.Callback<BaseResponse> {
//            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//        })
//        }
        }

        override fun post(url: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun put(url: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun delete(url: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}