import { ApiClient } from 'api/v1/common/apiClient';
//import { UserState, SignUpPayload } from '../../../models/User';


export const signUp = async (signInPayload) => {
    try {
        const { data } = await ApiClient.post(`api/v1/auth/signup`, JSON.stringify(signInPayload));
        return data;
    } catch (error) {
        return error;
    }
};