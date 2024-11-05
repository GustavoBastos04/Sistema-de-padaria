import {Form, InputGroup} from "react-bootstrap"
import {CiSearch} from "react-icons/ci";
import PropTypes from "prop-types";

function SearchInput({string, onSearch}) {

    const handleInputChange = (event) => {
        onSearch(event.target.value)
    }

    return(
        <div className="p-2 d-flex align-items-center justify-content-center">
        <InputGroup className="mb-3 w-25">
            <InputGroup.Text id="search-input"><CiSearch /></InputGroup.Text>
            <Form.Control
            placeholder={`Buscar por ${string}...`}
            aria-label={`Buscar por ${string}...`}
            aria-describedby="search-input"
            onChange={handleInputChange}
            />
        </InputGroup>
        </div>
    )
}

SearchInput.propTypes = {
    string: PropTypes.string.isRequired,
    onSearch: PropTypes.func.isRequired
}

export default SearchInput