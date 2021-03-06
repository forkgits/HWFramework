package android.media.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITvInputManagerCallback extends IInterface {

    public static abstract class Stub extends Binder implements ITvInputManagerCallback {
        private static final String DESCRIPTOR = "android.media.tv.ITvInputManagerCallback";
        static final int TRANSACTION_onInputAdded = 1;
        static final int TRANSACTION_onInputRemoved = 2;
        static final int TRANSACTION_onInputStateChanged = 4;
        static final int TRANSACTION_onInputUpdated = 3;
        static final int TRANSACTION_onTvInputInfoUpdated = 5;

        private static class Proxy implements ITvInputManagerCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onInputAdded(String inputId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(inputId);
                    this.mRemote.transact(Stub.TRANSACTION_onInputAdded, _data, null, Stub.TRANSACTION_onInputAdded);
                } finally {
                    _data.recycle();
                }
            }

            public void onInputRemoved(String inputId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(inputId);
                    this.mRemote.transact(Stub.TRANSACTION_onInputRemoved, _data, null, Stub.TRANSACTION_onInputAdded);
                } finally {
                    _data.recycle();
                }
            }

            public void onInputUpdated(String inputId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(inputId);
                    this.mRemote.transact(Stub.TRANSACTION_onInputUpdated, _data, null, Stub.TRANSACTION_onInputAdded);
                } finally {
                    _data.recycle();
                }
            }

            public void onInputStateChanged(String inputId, int state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(inputId);
                    _data.writeInt(state);
                    this.mRemote.transact(Stub.TRANSACTION_onInputStateChanged, _data, null, Stub.TRANSACTION_onInputAdded);
                } finally {
                    _data.recycle();
                }
            }

            public void onTvInputInfoUpdated(TvInputInfo TvInputInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (TvInputInfo != null) {
                        _data.writeInt(Stub.TRANSACTION_onInputAdded);
                        TvInputInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_onTvInputInfoUpdated, _data, null, Stub.TRANSACTION_onInputAdded);
                } finally {
                    _data.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITvInputManagerCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ITvInputManagerCallback)) {
                return new Proxy(obj);
            }
            return (ITvInputManagerCallback) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case TRANSACTION_onInputAdded /*1*/:
                    data.enforceInterface(DESCRIPTOR);
                    onInputAdded(data.readString());
                    return true;
                case TRANSACTION_onInputRemoved /*2*/:
                    data.enforceInterface(DESCRIPTOR);
                    onInputRemoved(data.readString());
                    return true;
                case TRANSACTION_onInputUpdated /*3*/:
                    data.enforceInterface(DESCRIPTOR);
                    onInputUpdated(data.readString());
                    return true;
                case TRANSACTION_onInputStateChanged /*4*/:
                    data.enforceInterface(DESCRIPTOR);
                    onInputStateChanged(data.readString(), data.readInt());
                    return true;
                case TRANSACTION_onTvInputInfoUpdated /*5*/:
                    TvInputInfo tvInputInfo;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        tvInputInfo = (TvInputInfo) TvInputInfo.CREATOR.createFromParcel(data);
                    } else {
                        tvInputInfo = null;
                    }
                    onTvInputInfoUpdated(tvInputInfo);
                    return true;
                case IBinder.INTERFACE_TRANSACTION /*1598968902*/:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onInputAdded(String str) throws RemoteException;

    void onInputRemoved(String str) throws RemoteException;

    void onInputStateChanged(String str, int i) throws RemoteException;

    void onInputUpdated(String str) throws RemoteException;

    void onTvInputInfoUpdated(TvInputInfo tvInputInfo) throws RemoteException;
}
