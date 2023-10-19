import { ApiClient } from 'api/v1/common/apiClient';


export const signIn = async (signInPayload: SignInPayload) => {
    try {
        const { data } = await ApiClient.post(`api/v1/auth/signIn`, signInPayload);
        return data;
    } catch (error) {
        return error;
    }
};