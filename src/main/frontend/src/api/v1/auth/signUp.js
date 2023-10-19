import { ApiClient } from 'api/v1/common/apiClient';
//import { UserState, SignUpPayload } from '../../../models/User';


export const signUp = async (signUpPayload) => {
    try {
        const { data } = await ApiClient.post(`api/v1/auth/signUp`, signUpPayload);
        return data;
    } catch (error) {
        return error;
    }
};