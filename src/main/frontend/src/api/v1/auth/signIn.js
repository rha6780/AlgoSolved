import { ApiClient } from 'api/v1/common/apiClient';


export const signIn = async (signInPayload) => {
    try {
        const { data } = await ApiClient.post(`api/v1/auth/login`, JSON.stringify(signInPayload));
        return data;
    } catch (error) {
        return error;
    }
};