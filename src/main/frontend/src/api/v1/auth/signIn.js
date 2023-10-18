import { ApiClient } from '/api/v1/common/apiClient';
import { UserState, SignInPayload } from '../../../models/User';


export const signIn = async (signInPayload: SignInPayload) => {
    try {
        const { data } = await ApiClient.post<UserState>(`api/v1/auth/signIn`, signInPayload);
        setAccessToken(data.token['access']);
        setCookie('refresh_token', data.token['refresh'], { secure: true }); //httpOnly: true,
        return data;
    } catch (error) {
        return error;
    }
};