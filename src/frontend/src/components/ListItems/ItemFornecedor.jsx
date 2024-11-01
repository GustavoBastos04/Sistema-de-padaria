import PropTypes from "prop-types";

function ItemFornecedor(props){
    return (
        <tr>
            <td>{props.nome}</td>
            <td>{props.cnpj}</td>
            <td>{props.tel}</td>
            <td>{props.email}</td>
            <td>{props.cep}</td>
        </tr>
    )
}

ItemFornecedor.propTypes = {
    nome: PropTypes.string.isRequired,
    cnpj: PropTypes.string.isRequired,
    tel: PropTypes.string.isRequired,
    email: PropTypes.string.isRequired,
    cep: PropTypes.string.isRequired,
}

export default ItemFornecedor;